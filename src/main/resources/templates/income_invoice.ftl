<#ftl encoding='UTF-8'>
<#import "parts/common.ftl" as c>

<@c.page>
<#include "parts/order_nav.ftl"/> 

<div class="container">
    <div class="bd-example">
      <div class="row  row-cols-1  ">
        <div class="col">
          <div class="card ">
            <div class="alert-secondary card-header">
               Прихід товару № 100 
            </div>
            <div class="card-body">        
                <form class="form-inline" action="/goods/new" method="post">
                  <div class="input-group mb-3">
                    <span class="input-group-text" for="">Дата</span>
                    <input type="date" name="date" id="" class="form-control" >
                  </div>
                  <div class="input-group mb-3">
                    <span class="input-group-text" for="">Постачальник</span>
                    <input list="providers" type="text" class="form-control" placeholder="постачальник" name="provider" id="">
                    <datalist id="providers" for="providers">
                      <option value="перший"></option>
                      <option value="другий">другий</option>
                      <option value="третій"></option>
                      <option value="четвертий"></option>
                    </datalist>
                  </div>
                  <div class="input-group mb-3">
                    <span class="input-group-text" for="">Склад</span>
                    <select name="storage" id="" class="form-control" accesskey="s">
                      <option value="first" >Склад 1</option>
                      <option value="second" selected>Склад 2</option>
                    </select>
                  </div>
                  <div class="input-group mb-3">
                    <span class="input-group-text" for="">Доставка</span>
                    <input type="number" class="form-control" placeholder="доставка" name="delivery" id="del" value="0" min="0">
                  </div>
                    <table class="table">
                        <thead class="thead-light">
                            <tr>
                                <th scope="col">№</th>
                                <th scope="col">назва</th>
                                <th scope="col">кількість</th>
                                <th scope="col">ціна (грн)</th>
                                <th scope="col">сума (грн)</th>
                                <th scope="col">тип товару</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <th scope="row">1</th>
                                <td><input class="form-control" type="text" name="goods1_name" id=""></td>
                                <td><input class="form-control" type="number" name="goods1_count" id="input11" value="1" min="0"></td>
                                <td><input class="form-control" type="number" step=any name="goods1_price" id="input12" value="" min="0"></td>
                                <td><input class="form-control" disabled="disabled" type="text" id="input13" value="" min="0"></td>
                                <td><select name="good1_type" class="form-control">
                                  <option value="consumables">розходники</option>
                                  <option value="for_sale" selected>товар для продажу</option>
                                  <option value="to_destroy">на розбор</option>
                                  <option value="equipment">обладняння</option>
                                </select></td>
                            </tr>
                            <tr>
                                <th scope="row">2</th>
                                <td><input class="form-control" type="text" name="goods2_name"id=""></td>
                                <td><input class="form-control" type="number" name="goods2_count" id="input21" value="0" min="0"></td>
                                <td><input class="form-control" type="number" step=any name="goods2_price" id="input22" value="0.0" min="0"></td>
                                <td><input class="form-control" disabled="disabled" type="text" id="input23" value="" min="0"></td>
                                <td><select name="good2_type" class="form-control">
                                  <option value="consumables">розходники</option>
                                  <option value="for_sale" selected>товар для продажу</option>
                                  <option value="to_destroy">на розбор</option>
                                  <option value="equipment">обладняння</option>
                                </select></td>
                            </tr>
                            <tr>
                                <th scope="row">3</th>
                                <td><input class="form-control" type="text" name="goods3_name"id=""></td>
                                <td><input class="form-control" type="number" name="goods3_count" id="input31" value="0" min="0"></td>
                                <td><input class="form-control" type="number" step=any name="goods3_price" id="input32" value="0.0" min="0"></td>
                                <td><input class="form-control" disabled="disabled" type="text" name="" id="input33" value="" min="0"></td>
                                <td><select name="good3_type" class="form-control">
                                  <option value="consumables">розходники</option>
                                  <option value="for_sale" selected>товар для продажу</option>
                                  <option value="to_destroy">на розбор</option>
                                  <option value="equipment">обладняння</option>
                                </select></td>
                            </tr>
                            <tr>
                                <th scope="row">4</th>
                                <td><input class="form-control" type="text" name="goods4_name"id=""></td>
                                <td><input class="form-control" type="number" name="goods4_count" id="input41" value="0" min="0"></td>
                                <td><input class="form-control" type="number" step=any name="goods4_price" id="input42" value="0.0" min="0"></td>
                                <td><input class="form-control" disabled="disabled" type="text" name="" id="input43" value="" min="0"></td>
                                <td><select name="good4_type" class="form-control">
                                  <option value="consumables">розходники</option>
                                  <option value="for_sale" selected>товар для продажу</option>
                                  <option value="to_destroy">на розбор</option>
                                  <option value="equipment">обладняння</option>
                                </select></td>
                            </tr>
                            <tr>
                                <th scope="row">5</th>
                                <td><input class="form-control" type="text" name="goods5_name" id=""></td>
                                <td><input class="form-control" type="number" name="goods5_count" id="input51" value="0" min="0"></td>
                                <td><input class="form-control" type="number" step=any name="goods5_price" id="input52" value="0.0" min="0"></td>
                                <td><input class="form-control" disabled="disabled" type="text" name="" id="input53" value="" min="0"></td>
                                
                                <td><select name="good5_type" class="form-control">
                                  <option value="consumables">розходники</option>
                                  <option value="for_sale" selected>товар для продажу</option>
                                  <option value="to_destroy">на розбор</option>
                                  <option value="equipment">обладняння</option>
                                </select></td>
                            </tr>
                            <tr>
                                <th scope="row">6</th>
                                <td><input class="form-control" type="text" name="goods6_name" id=""></td>
                                <td><input class="form-control" type="number" name="goods6_count" id="input61" value="0" min="0"></td>
                                <td><input class="form-control" type="number" step=any name="goods6_price" id="input62" value="0.0" min="0"></td>
                                <td><input class="form-control" disabled="disabled" type="text" name="" id="input63" value="" min="0"></td>
                                 <td><select name="good6_type" class="form-control">
                                  <option value="consumables">розходники</option>
                                  <option value="for_sale" selected>товар для продажу</option>
                                  <option value="to_destroy">на розбор</option>
                                  <option value="equipment">обладняння</option>
                                </select></td>
                            </tr>
                            <tr>
                                <th scope="row">7</th>
                                <td><input class="form-control" type="text" name="goods7_name" id=""></td>
                                <td><input class="form-control" type="number" name="goods7_count" id="input71" value="0" min="0"></td>
                                <td><input class="form-control" type="number" step=any name="goods7_price" id="input72" value="0.0" min="0"></td>
                                <td><input class="form-control" disabled="disabled" type="text" name="" id="input73" value="" min="0"></td>
                                <td><select name="good7_type" class="form-control">
                                  <option value="consumables">розходники</option>
                                  <option value="for_sale" selected>товар для продажу</option>
                                  <option value="to_destroy">на розбор</option>
                                  <option value="equipment">обладняння</option>
                                </select></td>
                            </tr>
                            <tr>
                                <th scope="row"></th>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td><div id="sum1"><i> Загальна сума (грн):</i> <b>0</b> </div></td>
                            </tr>
                        </tbody>
                    </table>
                    <input type="hidden" name="_csrf" value="${_csrf.token}" />
                    <input class="btn btn-secondary" type="submit" value="підтвердити">
                </form>
          </div>
<script src="/static/myjs.js"></script>
</@c.page>