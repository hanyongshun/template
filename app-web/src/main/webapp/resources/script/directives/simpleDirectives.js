var simpleModule = angular.module("simple", []);
simpleModule.directive("loader", function(){
	return {
		restrict: "AE",
		link: function(scope,element,attr){
			element.bind("mouseenter",function(){
				console.info("loaderData......");
			});
		}
	}
})