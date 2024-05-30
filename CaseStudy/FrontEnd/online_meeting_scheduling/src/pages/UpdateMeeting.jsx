import React, { useEffect, useState } from 'react';
import { useParams, useNavigate, Link } from 'react-router-dom';
import axios from 'axios';
import Form from 'react-bootstrap/Form';
import Button from 'react-bootstrap/Button';
import Col from 'react-bootstrap/Col';
import Row from 'react-bootstrap/Row';
import Table from 'react-bootstrap/Table';
import '../../src/style/updatemeeting.css';

const UpdateMeeting = () => {


  const [meetingDetails, setMeetingDetails] = useState({
    meetingId: '', 
    date: '',
    title: '',
    agenda: '',
    time: ''
  });

  const [meetings, setMeetings] = useState([]);

  useEffect(() => {
    fetchMeetingData();
  }, []);

  const fetchMeetingData = async () => {
    try {
      const response = await axios.get("http://localhost:8080/onlinemeeting/getall");
      if (response.data && Array.isArray(response.data)) {
        setMeetings(response.data);
      } else {
        console.error("Invalid response data format.");
      }
    } catch (error) {
      console.error("Error fetching meeting details: ", error);
    }
  };

  const handlePopulateForm = (selectedMeeting) => {
    setMeetingDetails(selectedMeeting);
  };



  const handleUpdateMeeting = async (e) => {
    e.preventDefault(); 

    try {
      const response = await axios.put(
        "http://localhost:8080/onlinemeeting/update", 
        {
          meetingId: meetingDetails.meetingId,
          date: meetingDetails.date,
          title: meetingDetails.title,
          agenda: meetingDetails.agenda,
          time: meetingDetails.time
        }
      );

      console.log("Meeting updated:", response.data);
      alert("Meeting Updated Successfully");
      fetchMeetingData()
    } catch (error) {
      console.error("Error updating meeting:", error);
    }
  };


  const handleChange = (e) => {
    const { name, value } = e.target;
    setMeetingDetails(prevDetails => ({
      ...prevDetails,
      [name]: value
    }));
  };

  return (
    <div className='update-meeting'>
      <h1 className='update-meeting-heading'>Update Meeting</h1>
      <div className='update-meeting-form-container'>
        <Form onSubmit={handleUpdateMeeting}>
          <Form.Group as={Row} controlId="formPlaintextTitle">
            <Form.Label column sm="2">
              MeetingId
            </Form.Label>
            <Col sm="10">
              <Form.Control
                type="text"
                name="meetingId"
                value={meetingDetails.meetingId}
                onChange={handleChange}
                placeholder="Enter meeting Id"
                disabled
              />
            </Col>
          </Form.Group><br/>

          <Form.Group as={Row} className="mb-4" controlId="formPlaintextTitle">
            <Form.Label column sm="2">
              Title
            </Form.Label>
            <Col sm="10">
              <Form.Control
                type='text'
                name='title'
                value={meetingDetails.title}
                onChange={handleChange}
                placeholder='Enter Meeting Title'
              />
            </Col>
          </Form.Group>

          <Form.Group as={Row} className="mb-4" controlId="formPlaintextAgenda">
            <Form.Label column sm="2">
              Agenda
            </Form.Label>
            <Col sm="10">
              <Form.Control
                type='text'
                name='agenda'
                value={meetingDetails.agenda}
                onChange={handleChange}
                placeholder='Enter Meeting Agenda'
              />
            </Col>
          </Form.Group>

          <Form.Group as={Row} className="mb-4" controlId="formPlaintextDate">
            <Form.Label column sm="2">
              Date
            </Form.Label>
            <Col sm="10">
              <Form.Control
                type='date'
                name='date'
                value={meetingDetails.date}
                onChange={handleChange}
                placeholder='Enter Meeting Date'
              />
            </Col>
          </Form.Group>

          <Form.Group as={Row} className="mb-4" controlId="formPlaintextTime">
            <Form.Label column sm="2">
              Time
            </Form.Label>
            <Col sm="10">
              <Form.Control
                type='time'
                name='time'
                value={meetingDetails.time}
                onChange={handleChange}
                placeholder='Enter Meeting Time'
              />
            </Col>
          </Form.Group>

          <Button type='submit' className='updatebtn'>Update Meeting</Button>
          <br /><br />
          <Link to="/adminevents">
            <Button variant="primary" className='updatebtn'>Back</Button>
          </Link>
        </Form>
      </div>

      <div className='meeting-table'>
        <h2>Meetings</h2>
        <Table striped bordered hover>
          <thead>
            <tr>
              <th>Meeting ID</th>
              <th>Title</th>
              <th>Agenda</th>
              <th>Date</th>
              <th>Time</th>
              <th>Action</th>
            </tr>
          </thead>
          <tbody>
            {meetings.map((meeting, index) => (
              <tr key={index}>
                <td>{meeting.meetingId}</td>
                <td>{meeting.title}</td>
                <td>{meeting.agenda}</td>
                <td>{meeting.date}</td>
                <td>{meeting.time}</td>
                <td>
                  <Button className='updatebtn' onClick={() => handlePopulateForm(meeting)}>Edit</Button>
                </td>
              </tr>
            ))}
          </tbody>
        </Table>
      </div>
    </div>
  );
}

export default UpdateMeeting;
