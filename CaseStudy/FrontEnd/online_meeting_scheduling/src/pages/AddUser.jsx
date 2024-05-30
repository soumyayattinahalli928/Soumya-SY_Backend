import React, { useState } from 'react';
import Col from 'react-bootstrap/Col';
import Form from 'react-bootstrap/Form';
import Row from 'react-bootstrap/Row';
import Button from 'react-bootstrap/Button';
import Modal from 'react-bootstrap/Modal';
import '../../src/style/adduser.css';
import NavBar from '../components/NavBar';
import axios from 'axios';

const AddUser = () => {
  const [formData, setFormData] = useState({
    firstname: '',
    email: '',
  });

  const [errors, setErrors] = useState({});
  const [showModal, setShowModal] = useState(false);

  const validateForm = () => {
    const newErrors = {};
    if (!formData.firstname) newErrors.firstname = 'Name is required';
    if (!formData.email) newErrors.email = 'Email is required';
    else if (!/\S+@\S+\.\S+/.test(formData.email)) newErrors.email = 'Email is invalid';
    return newErrors;
  };

  const handleSubmit = (e) => {
    e.preventDefault();
    const formErrors = validateForm();
    if (Object.keys(formErrors).length === 0) {
      addUser(formData);
      setShowModal(true);
      setFormData({ firstname: '', email: '' });
    } else {
      setErrors(formErrors);
    }
  };

  const addUser = (formData) => {
    axios
      .post("http://localhost:8080/onlinemeeting/saveuser", formData)
      .then((res) => {
        console.log(res.data);
        alert("New User added successfully");
      })
      .catch((error) => {
        console.error('Error registering user:', error);
        // Handle error cases if needed
      });
  };

  const handleClose = () => setShowModal(false);

  return (
    <div className='adduser'>
      <NavBar /><br /><br /><br />
      <div className="form-container">
        <h1 className="form-title">ADD AN USER</h1>
        <div className='user-form'>
          <Form onSubmit={handleSubmit}>
            <Form.Group as={Row} className="mb-4" controlId="formPlaintextName">
              <Form.Label column sm="2">
                Name
              </Form.Label>
              <Col sm="15">
                <Form.Control
                  type='text'
                  placeholder='Enter The Name'
                  value={formData.firstname}
                  onChange={(e) =>
                    setFormData({ ...formData, firstname: e.target.value })
                  }
                  isInvalid={!!errors.firstname}
                />
                <Form.Control.Feedback type="invalid">
                  {errors.firstname}
                </Form.Control.Feedback>
              </Col>
            </Form.Group>

            <Form.Group as={Row} className="mb-4" controlId="formPlaintextEmail">
              <Form.Label column sm="2">
                Email
              </Form.Label>
              <Col sm="15">
                <Form.Control
                  type='email'
                  placeholder='Enter an Email'
                  value={formData.email}
                  onChange={(e) =>
                    setFormData({ ...formData, email: e.target.value })
                  }
                  isInvalid={!!errors.email}
                />
                <Form.Control.Feedback type="invalid">
                  {errors.email}
                </Form.Control.Feedback>
              </Col>
            </Form.Group>

            <div className='button-container'>
              <Button variant="warning" type='submit'>Add a User</Button>
            </div>
          </Form>
        </div>

        <Modal show={showModal} onHide={handleClose}>
          <Modal.Header closeButton>
            <Modal.Title>User Added</Modal.Title>
          </Modal.Header>
          <Modal.Body>User has been added successfully!</Modal.Body>
          <Modal.Footer>
            <Button variant="secondary" onClick={handleClose}>
              Ok
            </Button>
          </Modal.Footer>
        </Modal>
      </div>
    </div>
  );
}

export default AddUser;
