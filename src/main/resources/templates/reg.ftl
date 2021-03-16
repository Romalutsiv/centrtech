<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
    <meta name="generator" content="Hugo 0.79.0">
    <title>Signin Template · Bootstrap v5.0</title>

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
    
<main class="form-signin" action="/login" method="post">
  <form  action="/reg" method="post">
  
    <img class="mb-4" src="/static/logo.jpg" alt="" width="150" height="150">
    <#--  <h1 class="h3 mb-3 fw-normal">Вхід</h1>  -->
    <label for="inputEmail" class="visually-hidden">Registration</label>
    <input type="text" name="username" id="inputEmail" class="form-control" placeholder="Login" required autofocus>
    <label for="inputPassword" class="visually-hidden">Password</label>
    <input type="password" name="password" id="inputPassword" class="form-control" placeholder="Password" required>
    <input type="hidden" name="_csrf" value="${_csrf.token}" />
    <button class="w-100 btn btn-lg btn-secondary" type="submit">Увійти</button>
    <p class="mt-5 mb-3 text-muted">&copy; 2017-2020</p>
  </form>
</main>


    
  </body>
</html>