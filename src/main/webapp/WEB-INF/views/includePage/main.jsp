
<!-- <div ng-app="InvoiceModule" ng-controller="InvoiceController as invoice">
  <b>Invoice:</b>
  <div>
    Quantity: <input type="number" min="0" ng-model="invoice.qty" required >
  </div>
  <div>
    Costs: <input type="number" min="0" ng-model="invoice.cost" required >
    <select ng-model="invoice.inCurr">
      <option ng-repeat="c in invoice.currencies">{{c}}</option>
    </select>
  </div>
  <div>
    <b>Total:</b>
    <span ng-repeat="c in invoice.currencies">
      {{invoice.total(c) | currency:c}}
    </span>
    <button class="btn" ng-click="invoice.pay()">Pay</button>
  </div>
</div> -->
<div ng-controller="TestController">
	<p>{{constantList.TEST_CONSTANT1}}</p>
	<p>{{constant}}</p>
	<p>{{valmsg}}</p>
	<p>{{valmsg|GenderFilter}}</p>
	<p>{{print(this.constructor.name,valmsg)}}</p>
	<p>{{print(this.constructor.name,valmsg)|GenderFilter}}</p>
	<p>{{valid}}</p>
</div>
