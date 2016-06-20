'use strict';

App.factory('ProductService', ['$http', '$q', function($http, $q){
	
	return{
		fecthAllProducts: function(){
			return $http.get('http://localhost:8080/Spring-MVC-Angular-JS/product/')
					.then(
							function(response){
								return response.data;
							},
							function(errResponse){
								console.error('Error while fetching products');
								return $q.reject(errResponse);
							}
					
					);
		},
		
		createProduct: function(product){
			return $http.post('http://localhost:8080/Spring-MVC-Angular-JS/product/', product)
					.then(
							function(response){
								return response.data;
							},
							function(errResponse){
								console.error('Error while creating product');
								return $q.reject(errResponse);
							}
					);
		}
		
	};
	
}]);