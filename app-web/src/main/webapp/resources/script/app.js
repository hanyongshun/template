var myApp = angular.module("myApp", ['ngRoute','simple']).config(['$routeProvider',function($routeProvider){
	$routeProvider.when("/",{
		templateUrl:'home',
		controller:function($scope){
			console.info("go to home" + $scope.name);
		},
		resolve:{
			"data":["$http",function($http){
				return{
					name:"wjm"
				}
			}]
		}
	}).when("/list",{
		templateUrl:'list',
		controller:function($scope){
			console.info("go to list");
		}
	}).when("/add",{
		templateUrl:'add'
	}).otherwise({
		redirectTo:"/"
	});
}]);


