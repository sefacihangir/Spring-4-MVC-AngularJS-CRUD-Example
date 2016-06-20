'use strict';

App.factory('ProductService', ['$http', '$q', function($http, $q){
	
	return{
		fecthAllProducts: function(){
			return $http.get('http://localhost:8080/SpringMVCAngularJS/product/')
					.then(
							function(response){
								return responde.data;
							},
							function(errResponse){
								console.error('Error while fetching products');
								return $q.reject(errResponse);
							}
					
					);
		}
		
	};
	
}]);