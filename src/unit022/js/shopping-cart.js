new Vue({
    el: '#shopping-cart',
    data: {
        books: [
            {name: '《java编程思想》', publishDate: '2020-9', price: 98.00, quantity: 1},
            {name: '《数据分析与数据原理》', publishDate: '2019-2', price: 39.00, quantity: 1},
            {name: '《Hadoop权威指南》', publishDate: '2019-10', price: 59.00, quantity: 1},
            {name: '《代码大全》', publishDate: '2018-8', price: 128.00, quantity: 1}
        ]
    },
    filters: {
        priceFormatter(val){
            return  val.toFixed(2);
        }
    },
    computed: {
        totalPrice: {
            get: function(){
                // 为每一个元素执行回调
                return this.books.reduce((preVal, book) => preVal + book.price * book.quantity, 0);
            }
        }
    },
    methods: {
        increase(idx){
            this.books[idx].quantity++;
        },
        reduce(idx){
            if(this.books[idx].quantity > 1){
                this.books[idx].quantity--;
            }else{
                this.books[idx].quantity = 1;
            }
        },
        remove(idx){
            // console.log(idx);
            this.books.splice(idx, 1);

        }
    }
});