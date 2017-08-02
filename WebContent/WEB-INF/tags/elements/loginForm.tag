<%@ tag description="Login Form" pageEncoding="UTF-8"%>

<!-- CSS -->
<link href="../../../resources/css/loginForm.css" rel="stylesheet">

<li>
    <div class="row">
        <div class="col-md-12">
            <h5 class="text-right">Login</h5>
            <form class="form" role="form" method="post" action="/user/login" accept-charset="UTF-8" id="login-nav">
                <div class="form-group">
                    <label class="sr-only" for="email">Email address</label>
                    <input type="email" class="form-control" id="email" placeholder="Email address" name="email" required>
                </div>
                <div class="form-group">
                    <label class="sr-only" for="password">Password</label>
                    <input type="password" class="form-control" id="password" placeholder="Password" name="password" required>
                    <div class="help-block text-right"><a href="">Forgot the password ?</a></div>
                </div>
                <div class="form-group">
                    <button type="submit" class="btn btn-primary btn-block">Sign in</button>
                </div>
            </form>
        </div>
        <div class="bottom text-center">
            <button class="btn btn-primary btn-block" data-toggle="modal" data-target="#registerModal">Register</button>
        </div>
    </div>
</li>