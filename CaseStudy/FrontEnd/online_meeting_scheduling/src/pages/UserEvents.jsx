import React, { useEffect, useState } from "react";
import axios from "axios";
import { Button } from "react-bootstrap";
import { Link } from "react-router-dom";
import NavAfterUserLogin from "../components/NavAfterUserLogin";
import "../../src/style/table.css";

function UserEvents() {
  const [meetingDetails, setMeetingDetails] = useState([]);

  useEffect(() => {
    getMeetingDetails();
  }, []);

  const getMeetingDetails = async () => {
    try {
      const response = await axios.get(
        "http://localhost:8080/onlinemeeting/getall"
      );
      if (response.data && Array.isArray(response.data)) {
        setMeetingDetails(response.data);
      } else {
        console.error("Invalid response data format.");
        setMeetingDetails([]);
      }
    } catch (error) {
      console.error("Error fetching meeting details: ", error);
      setMeetingDetails([]);
    }
  };

  const handleResponse = async (meetingId, responseValue) => {
    try {
      const userEmail = prompt("Please enter your email:");
      if (!userEmail) {
        alert("Email is required.");
        return;
      }

      const res = await axios.post(
        "http://localhost:8080/onlinemeeting/saveparticipant",
        {
          email: userEmail,
          meetingId,
          meetingParticipants: [
            {
              responseStatus: responseValue,
            },
          ],
        }
      );
      console.log("Response saved:", res.data);
      alert("You are in meeting!");
      getMeetingDetails();
    } catch (error) {
      console.error("Error saving response:", error);
      alert("Response not saved");
    }
  };

  const handleDecline = async (meetingId, responseValue) => {
    try {
      const userEmail = prompt("Please enter your email:");
      if (!userEmail) {
        alert("Email is required.");
        return;
      }

      const res = await axios.post(
        "http://localhost:8080/onlinemeeting/saveparticipant",
        {
          email: userEmail,
          meetingId,
          meetingParticipants: [
            {
              responseStatus: responseValue,
            },
          ],
        }
      );
      console.log("Response saved:", res.data);
      alert("You have declined the meeting!");
      getMeetingDetails();
    } catch (error) {
      console.error("Error saving response:", error);
      alert("Response not saved");
    }
  };

  return (
    <div>
      <NavAfterUserLogin />
      <div className="adminevents">
        <h1 className="eventheading">Upcoming Meetings</h1>
        <table className="custom-table">
          <thead>
            <tr>
              <th>Meeting ID</th>
              <th>Title</th>
              <th>Agenda</th>
              <th>Date</th>
              <th>Time</th>
              <th colSpan={"2"}>Action</th>
            </tr>
          </thead>
          <tbody>
            {meetingDetails.map((meeting, index) => (
              <tr key={index}>
                <td>{meeting.meetingId}</td>
                <td>{meeting.title}</td>
                <td>{meeting.agenda}</td>
                <td>{meeting.date}</td>
                <td>{meeting.time}</td>
                <td>
                  <div
                    style={{
                      display: "flex",
                      flexDirection: "row",
                      paddingLeft: "100px",
                      marginLeft: "110px",
                    }}
                  >
                    <Button
                      variant="outline-success"
                      style={{ width: "100px", marginRight: "100px" }}
                      onClick={() =>
                        handleResponse(meeting.meetingId, "ACCEPT")
                      }
                    >
                      ACCEPT
                    </Button>
                    &nbsp;
                    <Button
                      variant="outline-danger"
                      style={{ width: "100px", marginRight: "100px" }}
                      onClick={() =>
                        handleDecline(meeting.meetingId, "DECLINE")
                      }
                    >
                      DECLINE
                    </Button>
                  </div>
                </td>
              </tr>
            ))}
          </tbody>
        </table>
      </div>
    </div>
  );
}

export default UserEvents;
