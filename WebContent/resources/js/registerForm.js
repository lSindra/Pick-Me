    // JavaScript form validation

    var emailInput = document.getElementById("emailRegister");
    emailInput.setCustomValidity(emailInput.title);

    var nameInput = document.getElementById("nameRegister");
    nameInput.setCustomValidity(nameInput.title);

    var password1Input = document.getElementById("password1");
    password1Input.setCustomValidity(password1Input.title);

    var password2Input = document.getElementById("password2");

    var registerButton = document.getElementById("register-button");




    var supports_input_validity = function()
    {
        var i = document.createElement("input");
        return "setCustomValidity" in i;
    };

    if(supports_input_validity()) {

        function checkForm() {
            if (nameInput.classList.contains("green-color") &&
                emailInput.classList.contains("green-color") &&
                password1Input.classList.contains("green-color") &&
                password2Input.classList.contains("green-color")) {
                registerButton.disabled = false;
            } else {
                registerButton.disabled = true;

            }
        }

        function nameCheck() {
            if (!nameInput.validity.patternMismatch && nameInput.value !== "") {
                nameInput.classList.remove("red-color");
                nameInput.classList.add("green-color");
            } else {
                nameInput.classList.remove("green-color");
                nameInput.classList.add("red-color");
            }
            checkForm();
        }


        function emailCheck() {
            if (!emailInput.validity.patternMismatch && emailInput.value !== "") {
                emailInput.classList.remove("red-color");
                emailInput.classList.add("green-color");
            } else {
                emailInput.classList.remove("green-color");
                emailInput.classList.add("red-color");
            }
            checkForm();
        }

        function passwordCheck1() {
            if (!password1Input.validity.patternMismatch && password1Input.value !== "") {
                password1Input.classList.remove("red-color");
                password1Input.classList.add("green-color");
            } else {
                password1Input.classList.remove("green-color");
                password1Input.classList.add("red-color");
            }
            passwordCheck2();
            checkForm();
        }

        function passwordCheck2() {
            if (password1Input.value === password2Input.value && password2Input.value !== "") {
                password2Input.classList.remove("red-color");
                password2Input.classList.add("green-color");
            } else {
                password2Input.classList.remove("green-color");
                password2Input.classList.add("red-color");
            }
            checkForm();
        }

        
    }