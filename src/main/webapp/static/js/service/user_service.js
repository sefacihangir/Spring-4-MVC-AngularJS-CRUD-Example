'use strict';
 
App.factory('User', ['$resource', function($resource){
 
    return $resource(
    		'http://localhost:8080/Spring-MVC-Angular-JS-ngResource/user/:id',
    		{id: '@id'},
    		{
	            update: {
	                    method: 'PUT'
	            }
    		}         
    );
 
}]);