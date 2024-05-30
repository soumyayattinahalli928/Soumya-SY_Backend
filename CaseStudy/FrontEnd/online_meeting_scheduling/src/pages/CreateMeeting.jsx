import React, { useState } from "react";
import { Form } from "react-bootstrap";
import Button from "react-bootstrap/Button";
import { Link } from "react-router-dom";
import "../../src/style/createmeeting.css";
import NavBar from "../components/NavBar";
import axios from "axios";
import NavBarAfterLogin from "../components/NavBarAfterLogin";

const CreateMeeting = () => {
  const meeting = (formData) => {
    axios
      .post("http://localhost:8080/onlinemeeting/savemeeting", formData)
      .then((res) => console.log(res.data))
      .catch((error) => console.error("Error creating meeting: ", error));
  };

  const [formData, setFormData] = useState({
    meetingId: "",
    title: "",
    agenda: "",
    date: "",
    time: "",
  });

  const [errors, setErrors] = useState({
    date: "",
    time: "",
  });

  const handleDateChange = (event) => {
    const selectedDate = new Date(event.target.value);
    const currentDate = new Date();
    currentDate.setHours(0, 0, 0, 0);
    if (selectedDate >= currentDate) {
      setFormData({ ...formData, date: event.target.value });
      setErrors({ ...errors, date: "" });
    } else {
      setErrors({ ...errors, date: "Please select a current or future date." });
    }
  };

  const handleTimeChange = (event) => {
    const selectedTime = event.target.value;
    if (/^([01]\d|2[0-3]):([0-5]\d)$/.test(selectedTime)) {
      setFormData({ ...formData, time: selectedTime });
      setErrors({ ...errors, time: "" });
    } else {
      setErrors({ ...errors, time: "Please enter a valid time (HH:MM)." });
    }
  };

  const handleSubmit = () => {
    if (!formData.date) {
      setErrors((prevErrors) => ({ ...prevErrors, date: "Date is required." }));
    }
    if (!formData.time) {
      setErrors((prevErrors) => ({ ...prevErrors, time: "Time is required." }));
    }
    if (formData.date && formData.time) {
      meeting(formData);
    }
  };

  return (
    <div className="meeting">
      <NavBarAfterLogin />
      <br />
      <br />
      <div className="desc-container">
        <h1 className="mh">Meeting Details</h1>
        <br />
        <Form style={{ marginLeft: "40%" }}>
          <Form.Group className="mb-3" controlId="exampleForm.ControlInput1">
            <Form.Label className="lable">
              <h5>Title:</h5>
            </Form.Label>
            <Form.Control
              onChange={(event) =>
                setFormData({ ...formData, title: event.target.value })
              }
              name="title"
              type="text"
              className="input"
            />
          </Form.Group>
          <Form.Group className="mb-3" controlId="exampleForm.ControlTextarea1">
            <Form.Label className="lable">
              <h5>Agenda:</h5>
            </Form.Label>
            <Form.Control
              onChange={(event) =>
                setFormData({ ...formData, agenda: event.target.value })
              }
              name="agenda"
              as="textarea"
              rows={3}
              className="input"
            />
          </Form.Group>
          <Form.Group className="mb-3" controlId="exampleForm.ControlInput1">
            <Form.Label className="lable">
              <h5>Meeting Date:</h5>
            </Form.Label>
            <Form.Control
              onChange={handleDateChange}
              name="date"
              type="date"
              className="input"
            />
            {errors.date && <div style={{ color: "red" }}>{errors.date}</div>}
          </Form.Group>
          <Form.Group className="mb-3" controlId="exampleForm.ControlInput1">
            <Form.Label className="lable">
              <h5>Meeting Start Time:</h5>
            </Form.Label>
            <Form.Control
              onChange={handleTimeChange}
              name="time"
              type="time"
              className="input"
            />
            {errors.time && <div style={{ color: "red" }}>{errors.time}</div>}
          </Form.Group>
          <Button variant="danger">
            <Link
              to="/adminlogin"
              className="link"
              style={{ color: "white", textDecoration: "none" }}
            >
              Back
            </Link>
          </Button>{" "}
          <br />
          <Link to={"/adminevents"}>
            <Button
              variant="success"
              onClick={handleSubmit}
              style={{ marginTop: "20px" }}
            >
              Create Meeting
            </Button>{" "}
          </Link>
        </Form>
      </div>
    </div>
  );
};

export default CreateMeeting;
