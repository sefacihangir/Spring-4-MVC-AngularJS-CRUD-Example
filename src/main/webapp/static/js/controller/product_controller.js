'user strict';

App.controller('ProductController', ['$scope', 'ProductService', function($scope, ProductService) {
	var self = this;	
	self.product={id:null,description:'',category:null};
	self.products=[];
	
	self.fetchAllProducts = function(){
		ProductService.fecthAllProducts()
			.then(
					function(d) {
						self.products = d;						
					},
					function(errReponse){
						console.error('Error while fetching Products');
					}
			);
	};
	
	self.fetchAllProducts();
	
	self.reset = function(){
		self.product = {id:null,description:'',category:null};
		$scope.myForm.$setPristine();
	};
	
	self.submit = function(){
		if(self.product.id==null){
			console.log('Saving New Product', self.product);
			self.createProduct(self.product);
		}else{
			self.updateUser(self.product, self.product.id);
			console.log('Product update with id ', self.product.id);
		}
		self.reset();
	};
	
}]);