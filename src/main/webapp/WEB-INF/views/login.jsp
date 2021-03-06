<%@ page import="java.io.PrintWriter" %><%--
  Created by IntelliJ IDEA.
  User: john19970623
  Date: 2020/9/20
  Time: 12:21 am
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <link type="text/css" rel="stylesheet" href="css/materialize.min.css" media="screen,projection" />
    <link rel="stylesheet" href="css/login.css">
    <title>Login & Signup</title>
</head>
<body>
<!-- login & signup page -->
<div class="container">
    <ul class="tabs">
        <li id="signin" class="tab col s12">
            <a href="#in">
                Sign in
            </a>
        </li>
        <li id="signup" class="tab col s12">
            <a href="#up">
                Sign up
            </a>
        </li>
    </ul>
    <div id="in">
        <form id="loginForm" action="/doLogin" method="post">
            <div class="section">
                    <span class="teal-text">
                        <h5>Please sign in first</h5>
                    </span>
            </div>
            <span style="color: red">${errMessage}</span>
            <span style="color: lightseagreen">${successMessage}</span>
            <div class="row">
                <div class="input-field col s12">
                    <input id="sid" name="sid" type="text" class="validate" required />
                    <label for="sid">Student ID</label>
                </div>
            </div>
            <div class="row">
                <div class="input-field col s12">
                    <input id="password" name="password" minlength="6" type="password" class="validate" required />
                    <label for="password">Password</label>
                    <span class="helper-text" data-error="6 characters minimum"></span>
                </div>
            </div>
            <div class="row">
                <div class="col s6">
                    <button class="btn waves-effect waves-light" type="reset" name="action">Clear
                        <i class="material-icons right">send</i>
                    </button>
                </div>
                <div class="col s6">
                    <button class="btn waves-effect waves-light" type="submit" name="action">Sign in
                        <i class="material-icons right">send</i>
                    </button>
                </div>
            </div>
        </form>
    </div>
    <div id="up">
        <form id="regForm" action="doRegister" method="post">
            <div class="section">
                    <span class="teal-text">
                        <h5>Get a new account!</h5>
                    </span>
            </div>
            <div class="row">
                <div class="input-field col s12">
                    <input id="re_sid" name="re_sid" type="text" class="validate" required />
                    <label for="re_sid">Student ID</label>
                </div>
            </div>
            <div class="row">
                <div class="input-field col s6">
                    <input id="first_name" name="first_name" type="text" class="validate" required />
                    <label for="first_name">First Name</label>
                </div>
                <div class="input-field col s6">
                    <input id="last_name" name="last_name" type="text" class="validate" required />
                    <label for="last_name">Last Name</label>
                </div>
            </div>
            <div class="row">
                <div class="input-field col s12">
                    <select id="gender" name="gender">
                        <option value="secret">secret</option>
                        <option value="male">male</option>
                        <option value="female">female</option>
                    </select>
                    <label>Gender</label>
                </div>
            </div>
            <div class="row">
                <div class="input-field col s12">
                    <input id="re_password" name="re_password" minlength="6" type="password" class="validate" required />
                    <label for="re_password">Password</label>
                    <span class="helper-text" data-error="6 characters minimum">6 characters minimum</span>
                </div>
            </div>
            <div class="row">
                <div class="col s6">
                    <button class="btn waves-effect waves-light" type="submit">Sign up!
                        <i class="material-icons right">send</i>
                    </button>
                </div>
            </div>
        </form>
    </div>
</div>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script type="text/javascript" src="js/materialize.js"></script>
<script type="text/javascript" src="js/login.js"></script>
</body>
</html>
