import React, { useState } from "react";
import Button from "react-bootstrap/Button";
import Form from "react-bootstrap/Form";
import "../../src/style/forgotpassword.css";
import { Link, useNavigate } from "react-router-dom";

function ForgotPassword() {
  const [email, setEmail] = useState("");
  const [newPassword, setNewPassword] = useState("");
  const [confirmPassword, setConfirmPassword] = useState("");
  const navigate = useNavigate();

  const handleSubmit = async (e) => {
    e.preventDefault();

    if (newPassword !== confirmPassword) {
      alert("New password and confirm password do not match.");
      return;
    }

    const response = await fetch(
      "http://localhost:8080/onlinemeeting/updatepassword",
      {
        method: "PUT",
        headers: {
          "Content-Type": "application/json",
        },
        body: JSON.stringify({
          email: email,
          password: newPassword,
        }),
      }
    );

    const responseData = await response.json();

    if (
      responseData.error === false &&
      responseData.data === "Password updated successfully"
    ) {
      alert("Password updated successfully");
      navigate("/adminlogin");
      clearFields();
    } else {
      alert(responseData.message);
      clearFields();
    }
  };

  const clearFields = () => {
    setEmail("");
    setNewPassword("");
    setConfirmPassword("");
  };

  return (
    <div className="pwd">
      <h1
        style={{
          margin: "30px auto",
          textAlign: "center",
          backgroundColor: "#fff",
          padding: "30px",
          fontStyle: "oblique",
        }}
      >
        Forgot Password
      </h1>
      <div className="forgot">
        <Form onSubmit={handleSubmit}>
          <Form.Group controlId="formPlaintextEmail" className="mb-4">
            <Form.Label>Email:</Form.Label>
            <Form.Control
              type="text"
              placeholder="Enter an Email"
              value={email}
              onChange={(e) => setEmail(e.target.value)}
            />
          </Form.Group>
          <Form.Group controlId="formPlaintextNewPassword" className="mb-4">
            <Form.Label>New Password:</Form.Label>
            <Form.Control
              type="password"
              placeholder="Enter New Password"
              value={newPassword}
              onChange={(e) => setNewPassword(e.target.value)}
            />
          </Form.Group>
          <Form.Group controlId="formPlaintextConfirmPassword" className="mb-4">
            <Form.Label>Confirm Password:</Form.Label>
            <Form.Control
              type="password"
              placeholder="Confirm Password"
              value={confirmPassword}
              onChange={(e) => setConfirmPassword(e.target.value)}
            />
          </Form.Group>
          <Button variant="warning" type="submit" className="btns">
            Reset Password
          </Button>{" "}
          <br />
          <br />
          <Link to={"/adminlogin"}>
            <Button variant="info" className="btns">
              Back
            </Button>{" "}
          </Link>
        </Form>
      </div>
    </div>
  );
}

export default ForgotPassword;
