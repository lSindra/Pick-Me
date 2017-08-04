<%@ tag description="Register Form" pageEncoding="UTF-8"%>

<!-- CSS -->
<link href="../../../resources/css/registerForm.css" rel="stylesheet">

<div class="container" id="register-form">
    <div class="row centered-form">
        <div class="col-xs-12 col-sm-8 col-md-4 col-sm-offset-2 col-md-offset-4">
            <div class="panel panel-default">
                <div class="panel-heading">
                    <h1 class="panel-title">Sign up </h1>
                    <h6>Welcome</h6>
                </div>
                <div class="panel-body">
                    <form class="form" role="form" id="form" method="post" action="/user/register" accept-charset="UTF-8">
                        <div class="form-group">
                            <input type="text" name="name" id="nameRegister" class="form-control input-sm" placeholder="Name" required pattern="^[a-zA-Z\s]*$"
                                   oninput="nameCheck()"
                                   data-toggle="namePop" title="Popover Header" data-trigger="focus" data-content="Some content inside the popover">
                        </div>

                        <div class="form-group">
                            <input type="email" name="email" id="emailRegister" class="form-control input-sm" placeholder="Email Address" required  pattern="[A-Za-z0-9._%-+]+@[A-Za-z0-9.-]+\.[A-Za-z]{2,4}"
                                   oninput="emailCheck()"
                                   data-toggle="emailPop" title="Popover Header" data-trigger="focus" data-content="Some content inside the popover">
                        </div>

                        <div class="row">
                            <div class="col-xs-6 col-sm-6 col-md-6">
                                <div class="form-group">
                                    <input type="password" id="password1" class="form-control input-sm" placeholder="Password" required pattern="^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)[a-zA-Z\d]{6,}$"
                                           oninput="passwordCheck1()"
                                           data-toggle="passwordPop" title="Popover Header" data-trigger="focus" data-content="Some content inside the popover">
                                </div>
                            </div>
                            <div class="col-xs-6 col-sm-6 col-md-6">

                                <div class="form-group">
                                    <input type="password" id="password2" class="form-control input-sm" placeholder="Confirm Password" required
                                           oninput="passwordCheck2()">
                                </div>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="date">Birthday</label>
                            <input type="date" name="date" id="date" class="form-control input-sm">
                        </div>
                        <input type="submit" id="register-button" value="Register" class="btn btn-info btn-block" disabled>

                    </form>
                </div>
            </div>
        </div>
    </div>
</div>

<script src="../../../resources/js/registerForm.js"></script>