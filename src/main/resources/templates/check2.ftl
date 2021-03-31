  <#ftl encoding='UTF-8'>
<#import "parts/common.ftl" as c>

<@c.page>
<div> 
<h4>${order.getDateCreate()}</h4>
<form action="/orderchek/new" method="post">
      <ul id="list" class="list-group mb-3">
        <li id="all" class="list-group-item d-flex justify-content-between">
        <input type="hidden" name="name" value="qqq"></input>
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
        <input type="hidden" name="_csrf" value="${_csrf.token}" />
        <input type="submit"  class="btn btn-secondary" placeholder="Promo code">
        </div>
        
     </div>
     </form>
     </div>
</@c.page>
