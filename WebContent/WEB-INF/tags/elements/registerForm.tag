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
                    <form class="form" role="form" method="post" action="/user/register" accept-charset="UTF-8">
                        <div class="form-group">
                            <input type="text" name="name" id="name" class="form-control input-sm" placeholder="Name" required>
                        </div>

                        <div class="form-group">
                            <input type="email" name="email" id="email" class="form-control input-sm" placeholder="Email Address" required>
                        </div>

                        <div class="row">
                            <div class="col-xs-6 col-sm-6 col-md-6">
                                <div class="form-group">
                                    <input type="password" name="password" id="password" class="form-control input-sm" placeholder="Password" required>
                                </div>
                            </div>
                            <div class="col-xs-6 col-sm-6 col-md-6">

                                <div class="form-group">
                                    <input type="password" id="password_confirmation" class="form-control input-sm" placeholder="Confirm Password" required>
                                </div>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="date">Birthday</label>
                            <input type="date" name="date" id="date" class="form-control input-sm">
                        </div>
                        <input type="submit" value="Register" class="btn btn-info btn-block">

                    </form>
                </div>
            </div>
        </div>
    </div>
</div>