<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Login</title>
    <link rel="canonical" href="https://getbootstrap.com/docs/5.0/examples/sign-in/">
    <!-- Bootstrap core CSS -->
    <link href="/static/assets/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
      .bd-placeholder-img {
        font-size: 1.125rem;
        text-anchor: middle;
        -webkit-user-select: none;
        -moz-user-select: none;
        user-select: none;
      }
      @media (min-width: 768px) {
        .bd-placeholder-img-lg {
          font-size: 3.5rem;
        }
      }
    </style>
    <!-- Custom styles for this template -->
    <link href="/static/signin.css" rel="stylesheet">
  </head>
  <body class="text-center">  
    <main class="form-signin">
      <form  action="/login" method="post">
        <a href="https://centr-tech.com.ua/" target="_blank"><img class="mb-4" src="/static/logo.jpg" alt="" width="150" height="150"></a>
        <label for="inputEmail" class="visually-hidden">Login</label>
        <input type="text" name="username" id="inputEmail" class="form-control" placeholder="Login" required autofocus>
        <label for="inputPassword" class="visually-hidden">Password</label>
        <input type="password" name="password" id="inputPassword" class="form-control" placeholder="Password" required>
        <input type="hidden" name="_csrf" value="${_csrf.token}" />
        <button class="w-100 btn btn-lg btn-secondary" type="submit">Увійти</button>
        <p class="mt-5 mb-3 text-muted">&copy; 2021 - Центр.tech</p>
      </form>
    </main>
  </body>
</html>