var a = new Array(7)
  for (var i =0; i < a.length; i++){
    a[i] = [document.getElementById('input' +(i+1)+ '1'), document.getElementById('input' +(i+1)+ '2'), document.getElementById('input' +(i+1)+ '3')];
  }
  var sum1 = document.getElementById('sum1')
  var del = document.getElementById('del')
  console.log(a)
  for(var x = 0; x <a.length; x++){
  double(a, x)
  }

  function double(inp, x){
 
      inp[x][0].addEventListener('input', function(e) {
      inp[x][2].value = inp[x][0].value * inp[x][1].value
      sum1.innerHTML = '<i> Загальна сума (грн):</i> <b>' + (+del.value + +inp[0][2].value + +inp[1][2].value + +inp[2][2].value + +inp[3][2].value + +inp[4][2].value + +inp[5][2].value + +inp[6][2].value) +'</b>'
    })
    inp[x][1].addEventListener('input', function(e) {
      inp[x][2].value = inp[x][0].value * inp[x][1].value
      sum1.innerHTML = '<i> Загальна сума (грн):</i> <b>' + (+del.value + +inp[0][2].value + +inp[1][2].value + +inp[2][2].value + +inp[3][2].value + +inp[4][2].value + +inp[5][2].value + +inp[6][2].value) +'</b>'
      })
      del.addEventListener('input', function(e) {
        sum1.innerHTML = '<i> Загальна сума (грн):</i> <b>' + (+del.value + +inp[0][2].value + +inp[1][2].value + +inp[2][2].value + +inp[3][2].value + +inp[4][2].value + +inp[5][2].value + +inp[6][2].value) +'</b>'
      })
  }

  

  
  sum1.value = a[0][2] + a[1][2]
  console.log(sum1)
