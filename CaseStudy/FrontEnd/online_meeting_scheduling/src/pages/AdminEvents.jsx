import React, { useEffect, useState } from "react";
import axios from "axios";
import { Button } from "react-bootstrap";
import { Link } from "react-router-dom";
import "../../src/style/table.css";
import NavBarAfterLogin from "../components/NavBarAfterLogin";

function AdminEvents() {
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

  const handleDeleteAndUpdateMeeting = async (meetingId) => {
    try {
      await axios.delete("http://localhost:8080/onlinemeeting/deletemeeting", {
        data: {
          meetingId: meetingId,
        },
      });
      alert("Meeting deleted successfully");
      getMeetingDetails();
    } catch (error) {
      console.error("Error deleting meeting:", error);
    }
  };

  return (
    <div>
      <NavBarAfterLogin />
      <div className="adminevents">
        <h1 className="eventheading">Meeting Details</h1>
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
                    <Link to="/adduser">
                      <Button
                        variant="primary"
                        style={{ width: "100px", marginRight: "100px" }}
                      >
                        Add User
                      </Button>
                    </Link>
                    &nbsp;
                    <Link to="/updatemeeting">
                      <Button
                        variant="primary"
                        style={{ width: "130px", marginRight: "100px" }}
                      >
                        Edit Meeting
                      </Button>
                    </Link>
                    &nbsp;
                    <Button
                      variant="primary"
                      onClick={() =>
                        handleDeleteAndUpdateMeeting(meeting.meetingId)
                      }
                      style={{ width: "140px", marginRight: "100px" }}
                    >
                      Delete Meeting
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

export default AdminEvents;
