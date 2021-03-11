
<#ftl encoding='UTF-8'>
<#macro page>
<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
    <meta name="generator" content="Hugo 0.79.0">
    <title>Navbar Template · Bootstrap v5.0</title>

    <link rel="canonical" href="https://getbootstrap.com/docs/5.0/examples/navbars/">

    



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
    <!-- <link href="navbar.css" rel="stylesheet"> -->
    <#--  <link href="offcanvas.css" rel="stylesheet">  -->
    
<link href="/static/assets/dist/css/bootstrap.min.css" rel="stylesheet">
<link href="/static/cheatssheet.css" rel="stylesheet">
</head>
<body>

<nav class="navbar navbar-expand-lg navbar-light bg-light" aria-label="Eighth navbar example">
    <div class="container">
      <a class="navbar-brand" href="#">ЦЕНТР.tech</a>
      <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarsExample07" aria-controls="navbarsExample07" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>

      <div class="collapse navbar-collapse" id="navbarsExample07">
        <ul class="navbar-nav me-auto mb-2 mb-lg-0">
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="#" id="dropdown07" data-bs-toggle="dropdown" aria-expanded="false">Закази</a>
                <ul class="dropdown-menu" aria-labelledby="dropdown07">
                  <li><a class="dropdown-item" href="#">Нові      <span class="badge bg-danger text-light rounded-pill align-text-top">27</span></a> </li>
                  <li><a class="dropdown-item" href="#">Виконуються       <span class="badge bg-warning text-light rounded-pill align-text-top">7</span></a></li>
                  <li><a class="dropdown-item" href="#">Виконані (до оплати)      <span class="badge bg-success text-light rounded-pill align-text-top">3</span></a></li>
                  <li><a class="dropdown-item" href="#">Виконані (оплачені)</a></li>
                </ul>
              </li>
          <!-- <li class="nav-item active">
            <a class="nav-link" aria-current="page" href="#">Закази</a>
          </li> -->
          <li class="nav-item">
            <a class="nav-link" href="#">Товар </a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="#">Офіс</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="#">Звіти</a>
          </li>
          <li class="nav-item">
            <a class="nav-link disabled" href="#" tabindex="-1" aria-disabled="true">Disabled</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="#">Колцентр</a>
          </li>
          
        </ul>
        <!-- <form>
          <input class="form-control" type="text" placeholder="Пошук" aria-label="Search">
        </form> -->
        <a class="navbar-brand" href="#"><svg xmlns="http://www.w3.org/2000/svg" x="0px" y="0px"
          width="32" height="32"
          viewBox="0 0 172 172"
          style=" fill:#000000;"><g fill="none" fill-rule="nonzero" stroke="none" stroke-width="1" stroke-linecap="butt" stroke-linejoin="miter" stroke-miterlimit="10" stroke-dasharray="" stroke-dashoffset="0" font-family="none" font-weight="none" font-size="none" text-anchor="none" style="mix-blend-mode: normal"><path d="M0,172v-172h172v172z" fill="none"></path><g fill="#191919"><path d="M164.46984,83.98416c-1.86792,-2.58344 -46.28176,-63.34416 -92.22984,-63.34416c-36.04088,0 -65.36,29.31912 -65.36,65.36c0,36.04088 29.31912,65.36 65.36,65.36c45.94808,0 90.36192,-60.76072 92.22984,-63.34416c0.86688,-1.204 0.86688,-2.82768 0,-4.03168zM99.76,113.52h-55.04c0,-13.76 17.4064,-11.8336 20.0724,-19.01632c0.22016,-2.4596 0.1376,-4.17272 0.1376,-6.41904c-1.118,-0.5848 -3.19232,-4.31032 -3.526,-7.45448c-0.87376,-0.07224 -2.2532,-0.92536 -2.65912,-4.29656c-0.21672,-1.80944 0.65016,-2.82768 1.17648,-3.1476c-2.9584,-11.38984 -1.32784,-21.33832 12.17072,-21.586c3.37464,0 5.97184,0.90128 6.98664,2.6832c9.85216,1.36912 6.89376,14.62 5.4696,18.9028c0.52976,0.31992 1.3932,1.33816 1.17648,3.1476c-0.40592,3.3712 -1.78192,4.22432 -2.65912,4.29656c-0.33712,3.1476 -2.32888,6.86968 -3.44344,7.45448c0,2.24632 -0.08256,3.96288 0.1376,6.41904c2.35984,6.33648 18.67232,5.35608 20.00016,17.39952z"></path></g></g></svg>  Roma Lutsiv</a>
        <button type="button" class="btn btn-secondary">Вихід <svg xmlns="http://www.w3.org/2000/svg" x="0px" y="0px"
          width="26" height="26"
          viewBox="0 0 172 172"
          style=" fill:#000000;"><g fill="none" fill-rule="nonzero" stroke="none" stroke-width="1" stroke-linecap="butt" stroke-linejoin="miter" stroke-miterlimit="10" stroke-dasharray="" stroke-dashoffset="0" font-family="none" font-weight="none" font-size="none" text-anchor="none" style="mix-blend-mode: normal"><path d="M0,172v-172h172v172z" fill="none"></path><g fill="#FFFFFF"><path d="M39.69231,0c-10.95673,0 -19.84615,8.88942 -19.84615,19.84615v132.30769c0,10.95673 8.88942,19.84615 19.84615,19.84615h92.61538c10.95673,0 19.84615,-8.88942 19.84615,-19.84615v-34.31731l-13.23077,11.57692v22.74038c0,3.64363 -2.97176,6.61538 -6.61538,6.61538h-92.61538c-3.64363,0 -6.61538,-2.97176 -6.61538,-6.61538v-132.30769c0,-3.64363 2.97176,-6.61538 6.61538,-6.61538h92.61538c3.64363,0 6.61538,2.97176 6.61538,6.61538v22.74038l13.23077,11.57692v-34.31731c0,-10.95673 -8.88942,-19.84615 -19.84615,-19.84615zM109.15385,42.79327c-1.65385,0.49099 -3.30769,2.17067 -3.30769,6.61538v16.74519h-39.69231c-3.64363,0 -6.61538,2.97176 -6.61538,6.61538v26.46154c0,3.64363 2.97176,6.61538 6.61538,6.61538h39.69231v16.53846c0,8.47596 6.61538,6.61538 6.61538,6.61538l49.61538,-43l-49.61538,-43c0,0 -1.65385,-0.69772 -3.30769,-0.20673z"></path></g></g></svg></button>
      </div>
    </div>
  </nav>
  <p></p>
    <#nested>
<script src="/static/assets/dist/js/bootstrap.bundle.min.js"></script>
<script src="/static/cheatsheet.js"></script>

  
</body>
</html>   

</#macro>