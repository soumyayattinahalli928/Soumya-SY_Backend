import React from "react";
import Container from "react-bootstrap/Container";
import Nav from "react-bootstrap/Nav";
import Navbar from "react-bootstrap/Navbar";
import "../../src/style/navbar.css";
import { NavDropdown } from "react-bootstrap";

function NavAfterUserLogin() {
  return (
    <Navbar fixed="top">
      <Container>
        <div>
          <img className="meetingimg" src="./meeting.png" alt="" />
        </div>
        <Nav className="mr-auto">
          <Nav.Link href="/" className="fontcolor">
            Home
          </Nav.Link>
          <Nav.Link href="adminlogin" className="fontcolor">
            AdminLogin
          </Nav.Link>
          <Nav.Link href="userlogin" className="fontcolor">
            UserLogin
          </Nav.Link>

          <NavDropdown title="Events">
            <NavDropdown.Item href="/userevents">
              Upcoming Meetings
            </NavDropdown.Item>
          </NavDropdown>
          <Nav.Link href="/" className="fontcolor">
            Logout
          </Nav.Link>
        </Nav>
      </Container>
    </Navbar>
  );
}
export default NavAfterUserLogin;
