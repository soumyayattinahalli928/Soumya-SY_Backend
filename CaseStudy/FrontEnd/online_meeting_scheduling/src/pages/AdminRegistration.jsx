import Button from 'react-bootstrap/Button';
import Col from 'react-bootstrap/Col';
import Form from 'react-bootstrap/Form';
import Row from 'react-bootstrap/Row';
import { useState } from 'react';
import { Formik } from 'formik';
import * as yup from 'yup';
import '../../src/style/adminregistration.css';
import NavBar from '../components/NavBar';
import axios from 'axios';


const AdminRegistration = () => {


  const schema = yup.object().shape({
    role: yup.string().required('Role is required'),
    firstname: yup.string().required('First name is required'),
    lastname: yup.string().required('Last name is required'),
    phoneNo: yup.string().required('Phone number is required').matches(/^\d{10}$/, 'Phone number must be 10 digits'),
    email: yup.string().required('Email is required').email('Invalid email'),
    password: yup.string().required('Password is required').min(8, 'Password must be at least 8 characters long'),
  });

  const [formData, setFormData] = useState({
    role: '',
    firstname: '',
    lastname: '',
    phoneNo: '',
    email: '',
    password: '',
  });

  const registerUser = (formData) => {
    axios
      .post("http://localhost:8080/onlinemeeting/saveuser", formData)
      .then((res) => {
        console.log(res.data);
        alert("Registration successful");
        clearFields();
      })
      .catch((error) => {
        console.error('Error registering user:', error);
        alert("Registration failed. Please try again.");
        clearFields();
      });
  };

  const clearFields = () =>{
    setFormData({
      role: '',
      firstname: '',
      lastname: '',
      phoneNo: '',
      email: '',
      password: ''
    })
    };

  return (
    <div className='reg'>
      <NavBar /><br />
      <Formik
        validationSchema={schema}
        onSubmit={(values) => {
          registerUser(values);
        }}
        initialValues={formData}
      >
        {({ handleSubmit, handleChange, values, touched, errors }) => (
          <>
            <h1 className='regHeading'>Registration Form</h1>
            <br />
            <div className='adreg'>
              <div className='form'>
                <Form noValidate onSubmit={handleSubmit}>
                  <Row className='mb-1'>
                    <Form.Label className='labelcolor'>Role</Form.Label>
                    <Form.Select
                      aria-label="Default select example"
                      style={{ width: '70%' }}
                      name="role"
                      value={values.role}
                      onChange={handleChange}
                      isInvalid={touched.role && !!errors.role}
                    >
                      <option value="">-----select role----</option>
                      <option value={false}>user</option>
                      <option value={true}>admin</option>
                    </Form.Select>
                    <Form.Control.Feedback type='invalid'>
                      {errors.role}
                    </Form.Control.Feedback>
                  </Row>

                  <Row className='mb-1'>
                    <Form.Group as={Col} md='9' controlId='validationFormik01'>
                      <Form.Label className='labelcolor'>First name</Form.Label>
                      <Form.Control
                        type='text'
                        name='firstname'
                        placeholder='First name'
                        value={values.firstname}
                        onChange={handleChange}
                        isInvalid={touched.firstname && !!errors.firstname}
                      />
                      <Form.Control.Feedback type='invalid'>
                        {errors.firstname}
                      </Form.Control.Feedback>
                    </Form.Group>
                  </Row>
                  <Row className='mb-1'>
                    <Form.Group as={Col} md='9' controlId='validationFormik02'>
                      <Form.Label className='labelcolor'>Last name</Form.Label>
                      <Form.Control
                        type='text'
                        name='lastname'
                        placeholder='Last name'
                        value={values.lastname}
                        onChange={handleChange}
                        isInvalid={touched.lastname && !!errors.lastname}
                      />
                      <Form.Control.Feedback type='invalid'>
                        {errors.lastname}
                      </Form.Control.Feedback>
                    </Form.Group>
                  </Row>
                  <Row className='mb-1'>
                    <Form.Group as={Col} md='9' controlId='validationFormik03'>
                      <Form.Label className='labelcolor'>Phone Number</Form.Label>
                      <Form.Control
                        type='text'
                        name='phoneNo'
                        placeholder='Phone number'
                        value={values.phoneNo}
                        onChange={handleChange}
                        isInvalid={touched.phoneNo && !!errors.phoneNo}
                      />
                      <Form.Control.Feedback type='invalid'>
                        {errors.phoneNo}
                      </Form.Control.Feedback>
                    </Form.Group>
                  </Row>
                  <Row className='mb-1'>
                    <Form.Group as={Col} md='9' controlId='validationFormik04'>
                      <Form.Label className='labelcolor'>Email</Form.Label>
                      <Form.Control
                        type='email'
                        name='email'
                        placeholder='Email'
                        value={values.email}
                        onChange={handleChange}
                        isInvalid={touched.email && !!errors.email}
                      />
                      <Form.Control.Feedback type='invalid'>
                        {errors.email}
                      </Form.Control.Feedback>
                    </Form.Group>
                  </Row>
                  <Row>
                    <Form.Group as={Col} md='9' controlId='validationFormik05'>
                      <Form.Label className='labelcolor'>Password</Form.Label>
                      <Form.Control
                        type='password'
                        name='password'
                        placeholder='Password'
                        value={values.password}
                        onChange={handleChange}
                        isInvalid={touched.password && !!errors.password}
                      />
                      <Form.Control.Feedback type='invalid'>
                        {errors.password}
                      </Form.Control.Feedback>
                    </Form.Group>
                  </Row>
                  <br />
                  <Button type='submit' style={{ marginLeft: '1px' }}>Submit</Button>
                </Form>
              </div>
            </div>
          </>
        )}
      </Formik>
    </div>
  );
}

export default AdminRegistration;
