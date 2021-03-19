<#ftl encoding='UTF-8'>
<#macro page>

<!doctype html>
  <html lang="en">
    <head>
      <meta charset="utf-8">
      <meta name="viewport" content="width=device-width, initial-scale=1">
      <title>ЦЕНТР.tech Work</title>
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
    
      <link href="/static/assets/dist/css/bootstrap.min.css" rel="stylesheet">
    </head>

    <#assign
      known = Session.SPRING_SECURITY_CONTEXT??
    >
    <#if known>
      <#assign
      user = Session.SPRING_SECURITY_CONTEXT.authentication.principal
      name = user.getUsername()
    >

</#if>
    <body>
      <nav class="navbar navbar-expand-lg navbar-light bg-light" aria-label="Eighth navbar example">
        <div class="container">
          <a class="navbar-brand" href="/orders">ЦЕНТР.tech</a>
          <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarsExample07" aria-controls="navbarsExample07" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
          </button>
          <div class="collapse navbar-collapse" id="navbarsExample07">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
              <li class="nav-item">
                <a class="nav-link" href="#">Закази</a>
              </li>
              <li class="nav-item">
                <a class="nav-link" href="#">Склад</a>
              </li>
              <li class="nav-item">
                <a class="nav-link" href="#">Магазин</a>
              </li>
              <li class="nav-item">
                <a class="nav-link" href="https://centr-tech.com.ua/"><b>CRM</b></a>
              </li>
              <li class="nav-item">
                <a class="nav-link" href="#">Admin</a>
              </li>
            </ul>
            <a class="navbar-brand" href="#">${name}</a>
            <form action="/logout" method="post">
              <input type="hidden" name="_csrf" value="${_csrf.token}" />
              <input type="submit" class="btn btn-secondary" value="Вихід"></input>
            </form>
          </div>
        </div>
      </nav>
      <br>
        <#nested>
      <script src="/static/assets/dist/js/bootstrap.bundle.min.js"></script>
      <script src="/static/cheatsheet.js"></script>
    </body>
  </html>   
</#macro>