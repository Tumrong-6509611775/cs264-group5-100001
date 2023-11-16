function login() {
    var formData = new FormData(document.getElementById("myForm"));
    var email = document.getElementById("email").value;
    var password = document.getElementById("pwd").value;
    
    console.log("Username:", email);
    console.log("Password:", password);

    var formData = new FormData();
    formData.append('username', 'songsuk@gmail.com');
    formData.append('password', 'secretpassword');

    for (var pair of formData.entries()) {
        console.log(pair[0] + ': ' + pair[1]);
      }
    }
