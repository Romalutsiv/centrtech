  <#ftl encoding='UTF-8'>
<#import "parts/common.ftl" as c>

<@c.page>
<script src="https://cdn.jsdelivr.net/npm/vue/dist/vue.js"></script>
<script src="https://cdn.jsdelivr.net/npm/vue-resource@1.5.1"></script>
<div id="app" class="container">
  <div  class="row g-3">
    <div  class="col-md-5 col-lg-4 order-md-last" >
      <h4 class="d-flex justify-content-between align-items-center mb-3">
        <span class="text-muted">Заказ № ${order.getId()} від ${order.getDateCreate()}</span>
        <span id="counts" class="badge bg-secondary rounded-pill">0</span>
      </h4>
      <form action="/orderchek/new" method="post">
      <ul id="list" class="list-group mb-3">
        <li id="all" class="list-group-item d-flex justify-content-between">
          <span>Total (UAH)</span>
          <strong >₴0</strong>
        </li>
      </ul>

        <div class="input-group">
          <input type="text" class="form-control" placeholder="Promo code">
          <button type="submit" class="btn btn-secondary">Redeem</button>
        </div>
      
      <p></p><div class="form-row text-center">
        <div class="col-12">
        </div>
        <input type="hidden" name="order_id" value="${order.getId()}" />
        <input type="hidden" name="_csrf" value="${_csrf.token}" />
        <input type="submit"  class="btn btn-secondary" placeholder="Promo code">
           
        </div>
        
     <#--  </div>  -->
     </form>
    </div>
    
    <mes-list></mes-list>
</div></div>
<script src="/static/main.js"></script>
<#--  <script>  -->





<#--  </script>  -->
</@c.page>
