
<div class="panel panel-primary">
<div class="panel-footer">
FOOTER
<div ng-controller="TestController">
	<p>{{constant}}</p>
	<p>{{valmsg}}</p>
	<p>{{valmsg|GenderFilter}}</p>
	<p>{{print(this.constructor.name,valmsg)}}</p>
	<p>{{print(this.constructor.name,valmsg)|GenderFilter}}</p>
</div>
</div>
</div>