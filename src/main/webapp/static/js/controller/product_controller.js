'user strict';

App.controller('ProductController', ['$scope', 'ProductService', function($scope, ProductService) {
	var self = this;	
	self.product={id:null,description:'',category:null};
	self.products=[];
	self.helloMsgs = "Hello ll";	
	
	self.fetchAllProducts = function(){
		alert(self.products);
		ProductService.fecthAllProducts()
			.then(
					function(d) {
						self.products = d;						
					},
					function(errReponse){
						console.error('Error while fetching Products');
					}
			);
		alert(self.products);
	};
	
	self.fetchAllProducts();
	
}]);