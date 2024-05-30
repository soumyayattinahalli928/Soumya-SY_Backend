import React from 'react';
import 'bootstrap/dist/css/bootstrap.min.css';
import App from './App';
import ReactDOM from 'react-dom/client';
import AdminLogin from '../src/pages/AdminLogin'
import AdminRegistration from '../src/pages/AdminRegistration'
import UserLogin from '../src/pages/UserLogin'
import AdminEvents from '../src/pages/AdminEvents';
import {
  createBrowserRouter,
  RouterProvider,
} from "react-router-dom";
import CreateMeeting from '../src/pages/CreateMeeting';
import ForgotPassword from '../src/pages/ForgotPassword';
import AddUser from '../src/pages/AddUser';
import UserEvents from '../src/pages/UserEvents';
import UpdateMeeting from './pages/UpdateMeeting';




const router = createBrowserRouter([
  {
    path: "/",
    element: <App/>,
  },
  {
    path: "adminlogin",
    element: <AdminLogin/>,
  },
  {
    path: "userlogin",
    element: <UserLogin/>,
  },
  {
    path: "adminregistration",
    element: <AdminRegistration/>,
  }, 
  {
    path: "createmeeting",
    element: <CreateMeeting/>,
  },
  {
    path: "forgotpassword",
    element: <ForgotPassword/>,
  },
  {
    path: "adminevents",
    element: <AdminEvents/>,
  },
  {
    path: "adduser",
    element: <AddUser/>,
  },
  {
    path: "userevents",
    element: <UserEvents/>,
  },
  {
    path: "updatemeeting",
    element: <UpdateMeeting/>,
  }


]);

const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(

  <RouterProvider router={router}/>
  
);
