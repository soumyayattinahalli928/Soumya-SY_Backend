import React, { useEffect, useState } from "react";
import Form from "react-bootstrap/Form";
import Button from "react-bootstrap/Button";
import { Link, useNavigate } from "react-router-dom";
import "../../src/style/adminlogin.css";
import NavBar from "../components/NavBar";
import "bootstrap/dist/css/bootstrap.min.css";
import axios from "axios";

const AdminLogin = () => {
  useEffect(() => {}, []);

  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");
  const [errors, setErrors] = useState({});
  const navigate = useNavigate();

  const validateForm = () => {
    const newErrors = {};
    if (!email) newErrors.email = "Email is required";
    else if (!/\S+@\S+\.\S+/.test(email)) newErrors.email = "Email is invalid";
    if (!password) newErrors.password = "Password is required";
    return newErrors;
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    const formErrors = validateForm();

    if (Object.keys(formErrors).length === 0) {
      try {
        const response = await axios.post(
          "http://localhost:8080/onlinemeeting/adminlogin",
          {
            email: email,
            password: password,
          }
        );

        if (response.data === "Admin Login successful") {
          if (window.confirm("Do you want to create a meeting?")) {
            alert("Redirecting to create meeting page");
            clearFields();
            navigate("/createmeeting");
          } else {
            alert("Redirecting to meeting details page");
            clearFields();
            navigate("/adminevents");
          }
        } else {
          alert("Only admin can login!!");
          clearFields();
          navigate("/adminlogin");
        }
      } catch (error) {
        console.error("Error:", error);
        setErrors("An error occurred. Please try again.");
      }
    } else {
      setErrors(formErrors);
    }
  };

  const clearFields = () => {
    setEmail("");
    setPassword("");
    setErrors("");
  };

  return (
    <>
      <NavBar />
      <div className="admin">
        <div className="adminlogin">
          <h1 className="label" style={{ textAlign: "left" }}>
            Admin Login
          </h1>
          <br />
          <hr />
          <Form onSubmit={handleSubmit}>
            <Form.Group className="mb-3" controlId="formEmail">
              <Form.Label className="label">Email</Form.Label>
              <Form.Control
                className="input"
                type="email"
                placeholder="name@example.com"
                value={email}
                onChange={(e) => setEmail(e.target.value)}
                isInvalid={!!errors.email}
                style={{ backgroundColor: "white", borderColor: "white" }}
              />
              <Form.Control.Feedback type="invalid">
                {errors.email}
              </Form.Control.Feedback>
            </Form.Group>

            <Form.Group className="mb-3" controlId="formPassword">
              <Form.Label className="label">Password</Form.Label>
              <Form.Control
                className="input"
                type="password"
                placeholder="Password"
                value={password}
                onChange={(e) => setPassword(e.target.value)}
                isInvalid={!!errors.password}
              />
              <Form.Control.Feedback type="invalid">
                {errors.password}
              </Form.Control.Feedback>
            </Form.Group>

            <a href="forgotpassword">Forgot Password?</a>
            <br />
            <br />
            <Button variant="primary" className="btn" type="submit">
              Login
            </Button>
            <br />
            <br />
            {errors.api && <div className="error-message">{errors.api}</div>}
            <p className="label">
              Don't have an account?
              <a href="adminregistration"> SignIn</a>
            </p>
          </Form>
        </div>
      </div>
    </>
  );
};

export default AdminLogin;
