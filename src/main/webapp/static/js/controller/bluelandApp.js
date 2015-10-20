/**
 * 
 */

'use strict';
// <![CDATA[
//
// Common Service & Config Setting
//
// ]]>

// DIRECTIVE
var BLdirective = angular.module('BlueLand.directive', []);

// FILTER
var BLfilter = angular.module('BlueLand.filter', []);

BLfilter.filter('GenderFilter', function() {
	return function(gender) {
		return '[filter : ' + gender + ' ]';
	};
});

// FACTORY
var BLfactory = angular.module('BlueLand.factory', []);

// SERVICE
var BLservice = angular.module('BlueLand.service', []);

// CONSTATANTS
var BLconstants = angular.module('BlueLand.constatns', []);

BLconstants.constant("TEST_CONSTANT", "constant1 value");
BLconstants.constant("TEST_CONSTANT_LIST", {
	"TEST_CONSTANT1" : "constant_list - contstant1 value",
	"TEST_CONSTANT2" : "constant_list - contstant2 value",
	"TEST_CONSTANT3" : "constant_list - contstant3 value"
});
// VALUE
var BLvalue = angular.module('BlueLand.value', []);
BLvalue.value('ValidationMessageValueService', {
	validationMessage : 'init validation msg'
});

BLvalue.value('PrintValueService', {
	print : function(module, message) {
		return 'PrintMethod - ' + module + ' Message : [' + message + ']';
	}
});

BLconstants.constant("TEST_CONSTANT", "constant1 value");
BLconstants.constant("TEST_CONSTANT_LIST", {
	"TEST_CONSTANT1" : "constant_list - contstant1 value",
	"TEST_CONSTANT2" : "constant_list - contstant2 value",
	"TEST_CONSTANT3" : "constant_list - contstant3 value"
})

// CONTROLLER
var BLcontroller = angular.module('BlueLand.controller', []);
BLcontroller.controller('TestController', [
		'$scope',
		'ValidationMessageValueService',
		'PrintValueService',
		'TEST_CONSTANT',
		function($scope, ValidationMessageValueService, PrintValueService,
				TEST_CONSTANT) {
			$scope.valmsg = ValidationMessageValueService.validationMessage;
			$scope.print = PrintValueService.print;
			$scope.constant = TEST_CONSTANT;
		} ]);

// <![CDATA[
//
// Common Modules Setting
//
// ]]>

// Common Modules
var defaultModules = [ 'BlueLand.service', 'BlueLand.directive',
		'BlueLand.filter', 'BlueLand.constatns', 'BlueLand.controller',
		'BlueLand.value', 'ngRoute', 'ngMessages' ];

// Add New Modules for each Page
var referenceModules = [ 'MemberModule' ];

var BlueLandApp = angular.module('BlueLandApp', defaultModules
		.concat(referenceModules));

// 각 페이지에 필요한 모듈만 선언하여 사용(로딩되는 스크립트 양을 줄이기 위해)
// - 변수: include되는 스크립트와의 연결을 위해
// - 중복되는 변수 혹은 인스턴스 명을 사용하지 않아야함(특히 Common)
var MemberModule = angular.module('MemberModule', []);
var InvoiceModule = angular.module('InvoiceModule', []);
