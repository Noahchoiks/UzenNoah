
<div class="panel panel-success">
<div class="panel-heading">
HEADER
<div ng-controller="TestController">
	<p>{{constant}}</p>
	<p>{{valmsg}}</p>
	<p>{{valmsg|GenderFilter}}</p>
	<p>{{print(this.constructor.name,valmsg)}}</p>
	<p>{{print(this.constructor.name,valmsg)|GenderFilter}}</p>
</div>
</div>
</div>