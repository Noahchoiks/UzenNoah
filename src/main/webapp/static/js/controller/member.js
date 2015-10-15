var memberMode = angular.module('memberMode', [ 'ngRoute' ]);

memberMode.factory('MemberService', function() {
	return {
		memberTemp : {
			id : 'noah1@noah.com',
			name : 'noah1',
			password : 'noah1',
			sex : 'm'
		}
	};
});

memberMode.controller('MemberRegisterController', [ '$scope', '$http',
		'$location', 'MemberService',
		function($scope, $http, $location, MemberService) {
			var memberTemp = MemberService.memberTemp;
			$scope.memberTemp = memberTemp;
			$scope.confirmPassword = '';

			$scope.onSubmit = function() {
				var dataObj = {
					id : memberTemp.id,
					name : memberTemp.name,
					password : memberTemp.password,
					sex : memberTemp.sex
				};
				var res = $http.post('/factory/isExistID', dataObj);
				res.success(function(data, status, headers, config) {
					if (data.result) {
						alert("SUCCESS");
						memberTemp = dataObj;
						$location.path('/confirm');
					} else {
						alert("FAILED : Duplicate ID");
					}
				});
				res.error(function(data, status, headers, config) {
					// convert Object to String
					alert("failure message: Unknown Error" + JSON.stringify({
						data : data
					}));
				});
			};
		} ]);
memberMode.controller('MemberConfirmController', [ '$scope', '$http',
		'$window', '$location', 'MemberService',
		function($scope, $http, $window, $location, MemberService) {
			$scope.memberData = MemberService.memberTemp;
			$scope.register = function() {
				var res = $http.post('/factory/join', $scope.memberData);
				res.success(function(data, status, headers, config) {
					if (data.result) {
						 $window.location.href = "/member/confirm";
					}
				});
			};
			$scope.back = function() {
				$window.history.back();
			};
		} ]);

memberMode.config(function($routeProvider, $locationProvider) {
	$routeProvider.when('/register', {
		templateUrl : '../static/js/controller/templates/memberRegister.html',
		controller : 'MemberRegisterController'
	}).when('/confirm', {
		templateUrl : '../static/js/controller/templates/memberConfirm.html',
		controller : 'MemberConfirmController'
	});
});
