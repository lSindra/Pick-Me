<%@ tag description="Login Form" pageEncoding="UTF-8"%>

<li>
    <div class="row">
        <div class="col-md-12">
            Login
            <form class="form" role="form" method="post" action="login" accept-charset="UTF-8" id="login-nav">
                <div class="form-group">
                    <label class="sr-only" for="exampleInputEmail2">Email address</label>
                    <input type="email" class="form-control" id="exampleInputEmail2" placeholder="Email address" required>
                </div>
                <div class="form-group">
                    <label class="sr-only" for="exampleInputPassword2">Password</label>
                    <input type="password" class="form-control" id="exampleInputPassword2" placeholder="Password" required>
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