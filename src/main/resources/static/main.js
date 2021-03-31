
var messageApi = Vue.resource('/chek{/id}');
var mmm = new Array
var ar = new Array
var showV = true
// var count = 0
Vue.component('message-row', {
    props: ['message'],
    data: function(){
        return {
            show: false 
        }
    },
    template: 
        '<div :id=message.butn class="d-flex">' +
            '<li class="list-group-item d-flex justify-content-between lh-sm col-9">' +
                '<div>' +
                    '<h6 class="my-0">{{message.name}}</h6>'+ 
                    '<small v-if="message.storage_count == null" :id="message.name" class="text-muted"></small>' +
                    '<small v-else :id="message.name" class="text-muted">кількість на складі: {{message.storage_count}}</small>' +
                '</div>'+
                '<span class="text-muted">{{message.price}} UAH</span>'+
            '</li>'+
            '<button v-show="message.storage_count!=0" :id=message.but type="button" class="btn btn-outline-secondary col-3" @click="add(message)"><h3>+</h3></button>'+
        '</div>',
    methods:{
        add(message){
            console.log(message.storage_count)
            var all = document.getElementById('all')
            var stor = document.getElementById(message.name)
            
            var but = document.getElementById(message.but)
            
            // if(message.storage_count == 1){
            //     document.getElementById(message.but).remove()
            // }
            if(mmm.includes(message)){
                mmm[mmm.indexOf(message)].count = (+mmm[mmm.indexOf(message)].count +1) 
                var suma = (+mmm[mmm.indexOf(message)].price * +mmm[mmm.indexOf(message)].count)
                var counts = document.getElementById(mmm[mmm.indexOf(message)].name +'counter')
                var sumaEl = document.getElementById(mmm[mmm.indexOf(message)].name +'suma')
                // if(mmm[mmm.indexOf(message)].storage_count == 1){
                // document.getElementById(message.but).remove()}
                mmm[mmm.indexOf(message)].storage_count = (+mmm[mmm.indexOf(message)].storage_count - +1)
                counts.innerText = 'кількість '+ mmm[mmm.indexOf(message)].count + 'x' +mmm[mmm.indexOf(message)].price +'₴'
                sumaEl.innerText = '₴' + suma 
                if(message.storage_count != NaN){   
                stor.innerText='кількість на складі: ' + mmm[mmm.indexOf(message)].storage_count}
                if(mmm[mmm.indexOf(message)].storage_count == 0) {
                    console.log(mmm[mmm.indexOf(message)].storage_count)
                }
            }else{
                mmm.push(message)
                var elem = mmm[mmm.indexOf(message)].id
                // if(mmm[mmm.indexOf(message)].storage_count == 1){
                // document.getElementById(message.but).remove()}

                mmm[mmm.indexOf(message)].storage_count = (+mmm[mmm.indexOf(message)].storage_count - +1)
                if(message.storage_count != null){   
                    stor.innerText='кількість на складі: ' + mmm[mmm.indexOf(message)].storage_count}
                list.insertAdjacentHTML('afterbegin',
                    '<div id="' + mmm[mmm.indexOf(message)].name +'c" class="row">'+
                        '<button type="button" class="btn btn-outline-secondary col-3" onclick="rem('+ elem +')"><h6>-</h6></button>'+   
                        '<li class="col list-group-item d-flex justify-content-between lh-sm">'+
                        '<div>'+
                            '<h6 class="my-0">' + mmm[mmm.indexOf(message)].name + '</h6>'+
                            '<input type="hidden" name="'+mmm[mmm.indexOf(message)].name+'_name" value="'+mmm[mmm.indexOf(message)].name+'"></input>'+
                            '<small id="' + mmm[mmm.indexOf(message)].name +'counter" class="text-muted">кількість '+ mmm[mmm.indexOf(message)].count + 'x' +mmm[mmm.indexOf(message)].price+'₴</small>' +
                        '</div>' +
                        '<span id="' + mmm[mmm.indexOf(message)].name +'suma" class="text-muted">₴' + mmm[mmm.indexOf(message)].price+'</span>'+
                        '</li>'+
                    '</div>'
                );
            }
            var counts = document.getElementById('counts')
            var sum = 0
            var cx = 0
            for (var i = 0; i < mmm.length; i++){
                sum = (+sum + (+mmm[i].price * +mmm[i].count))
                cx = (+cx + +mmm[i].count)
            }
            counts.innerText = cx
            all.innerHTML = '<span>Total (UAH)</span><strong >₴' + sum  + '</strong>'  
        }
        
    }
});


Vue.component('mes-list', {
  props: [ ],
  data(){
    return{
        search: '',
        messages:[]
    }
  },
  template:
    '<div class="col-md-7 col-lg-8">' +
        '<h4 class="col-md-6">Виберіть проданий товар</h4>'+
        '<div class="col-sd-5 col-lg-7">'+
            '<input  v-model="search" id="saerch" class="form-control" placeholder="Ведіть назву товару чи послуги">'+
        '</div><br>' +
        '<div class="col-md-8 col-lg-7">' +
            '<ul class="list-group mb-4">'+
                '<message-row  v-for="message in searchHendler" :key="message.id" :message="message"/>'+
                '</ul>'+
        '</div>'+
    '</div>',
    created: function() {
        messageApi.get().then(result =>
            result.json().then(data =>
                data.forEach(message => {
                    this.messages.push(message)
                    ar.push(message)
                })
            )
        )
    },
    computed:{
        searchHendler(){

            var s = this.search.toLowerCase();
            return this.messages.filter(el =>{
                return Object.values(el).some(m => m.toString().toLowerCase().includes(s))
            })
        }
    }

});

var app = new Vue({
  el: '#app',
});


function rem(mes){
    var mes_del;
    mmm.forEach((e =>{
        // console.log(e.id)
        if(e.id == mes){
            mes_del = e
        }
    }))
    var cx = 0
    var butn = document.getElementById(mes_del.butn)
    var stor = document.getElementById(mes_del.name)
    var sum = 0
    var counts = document.getElementById('counts')
    var suma = (+mmm[mmm.indexOf(mes_del)].price * +mmm[mmm.indexOf(mes_del)].count)
    var countses = document.getElementById(mmm[mmm.indexOf(mes_del)].name +'counter')
    var sumaEl = document.getElementById(mmm[mmm.indexOf(mes_del)].name +'suma')
    if(mmm[mmm.indexOf(mes_del)].count == 1){
        // if(mmm[mmm.indexOf(mes_del)].storage_count == 0){
        //     butn.insertAdjacentHTML('beforeend', '<button id="' + mes_del.but +'" type="button" class="btn btn-outline-secondary col-3" onclick="adds('+mes_del.id+')"><h3>+</h3></button>')
        // }
        mmm[mmm.indexOf(mes_del)].storage_count = (+mmm[mmm.indexOf(mes_del)].storage_count + +1)
        stor.innerText='кількість на складі: ' + mmm[mmm.indexOf(mes_del)].storage_count
        document.getElementById(mmm[mmm.indexOf(mes_del)].name + 'c').remove()
        mmm.splice(mmm.indexOf(mes_del), 1)
        for (var i = 0; i < mmm.length; i++){
            sum = (+sum + (+mmm[i].price * +mmm[i].count))
            cx = (+cx + +mmm[i].count)
        }
        counts.innerText = cx
        all.innerHTML = '<span>Total (UAH)</span><strong >₴' + sum  + '</strong>'
    }else{
    mmm[mmm.indexOf(mes_del)].count = (+mmm[mmm.indexOf(mes_del)].count - +1) 
    if(mmm[mmm.indexOf(mes_del)].storage_count == 0){
        // butn.insertAdjacentHTML('beforeend', '<button id="' + mes_del.but +'" type="button" class="btn btn-outline-secondary col-3" onclick="adds('+mes_del.id+')"><h3>+</h3></button>')
    }
        countses.innerText = 'кількість '+ mmm[mmm.indexOf(mes_del)].count + 'x' +mmm[mmm.indexOf(mes_del)].price +'₴'
        suma = (+mmm[mmm.indexOf(mes_del)].count * +mmm[mmm.indexOf(mes_del)].price)
        mmm[mmm.indexOf(mes_del)].storage_count = (+mmm[mmm.indexOf(mes_del)].storage_count + +1)
        stor.innerText='кількість на складі: ' + mmm[mmm.indexOf(mes_del)].storage_count
        sumaEl.innerText = '₴' + suma
        for (var i = 0; i < mmm.length; i++){
        sum = (+sum + (+mmm[i].price * +mmm[i].count))
        cx = (+cx + +mmm[i].count)
        }
        counts.innerText = cx
        all.innerHTML = '<span>Total (UAH)</span><strong >₴' + sum  + '</strong>'  
    }
}
console.log(ar)