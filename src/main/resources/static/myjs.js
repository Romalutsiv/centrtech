var a = new Array()
var s= new Array(a.length)
// var qw = new Array()
  var b = [document.getElementById('input1'), document.getElementById('input2'), document.getElementById('input3')]
  a.push(b)
  var sum1 = document.getElementById('sum1')
  var del = document.getElementById('del')
  console.log(a)
  double(a)
  

  function double(inp){
      
      var ss = 0
        inp.forEach(function(el, i){
          el[0].addEventListener('input', function(e) {
          el[2].value = el[0].value * el[1].value
          s[i] = el[2].value
          ss = s.reduce(function(a,b){
            return (+a)+(+b);
          })
          console.log(ss)
          sum1.innerHTML = '<i> Загальна сума (грн):</i> <b>' + (+del.value + +ss) +'</b>'
        })
      })      
      inp.forEach(function(el, i){
        el[1].addEventListener('input', function(e) {
        el[2].value = el[0].value * el[1].value
        s[i] = el[2].value
        ss = s.reduce(function(a,b){
        return (+a)+(+b);
      })
        console.log(ss)
        sum1.innerHTML = '<i> Загальна сума (грн):</i> <b>' + (+del.value + +ss) +'</b>'
      })
    })  
      

      

      del.addEventListener('input', function(e) {
        
        sum1.innerHTML = '<i> Загальна сума (грн):</i> <b>' + (+del.value + +ss) +'</b>' 
        
      })
  }

 

  

  function addRow(id){
    sell = document.getElementById('sell')
    var tbody = document.getElementById(id).getElementsByTagName("TBODY")[0];
    var row = document.createElement("TR")
    var td1 = document.createElement("TH")
    td1.appendChild(document.createTextNode(a.length + +1))
    
    var td2 = document.createElement("TD")
    var td3 = document.createElement("TD")
    var td4 = document.createElement("TD")
    var td5 = document.createElement("TD")
    var td6 = document.createElement("TD")
    var inpname = document.createElement('input')
    inpname.className = 'form-control'
    inpname.name = 'name'
    td2.appendChild (inpname)
    var inpcount = document.createElement('input')
    inpcount.type = 'number'
    inpcount.name = 'count'
    inpcount.className = 'form-control'
    inpcount.value = '1'
    inpcount.min = '0'
    td3.appendChild (inpcount)
    var inpprice = document.createElement('input')
    inpprice.className = 'form-control'
    inpprice.type = 'number'
    inpprice.name = 'price'
    inpprice.min = '0.0'
    inpprice.value = '0.0'
    inpprice.step = 'any'
    td4.appendChild (inpprice)
    var sel = document.createElement('select')
    sel.className = 'form-control'
    sel.name = "type"
    var op = document.createElement('option')
    for(var i =0; i < sell.length; i++){
      sel.options[i] = new Option(sell.options[i].text, sell.options[i].value)
    }
    var inpsum = document.createElement('input')
    inpsum.className = 'form-control'
    inpsum.disabled = 'disabled'
    td5.appendChild (inpsum)
    td6.appendChild (sel)
    a.push([inpcount, inpprice, inpsum])
    row.appendChild(td1);
    row.appendChild(td2);
    row.appendChild(td3);
    row.appendChild(td4);
    row.appendChild(td5);
    row.appendChild(td6);
    tbody.appendChild(row);
    double(a)
  }

  Date.prototype.toDateInputValue = (function() {
    var local = new Date(this);
    local.setMinutes(this.getMinutes() - this.getTimezoneOffset());
    return local.toJSON().slice(0,10);
});
document.getElementById('datePicker').value = new Date().toDateInputValue();
