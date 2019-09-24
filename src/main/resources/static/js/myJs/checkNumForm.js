function TestRgexp(re, s){ // 参数说明 re 为正则表达式 s 为要判断的字符 
return re.test(s) 
} 
function isPositiveFloat(s){
	var re=/^(([0-9]+\.[0-9]*[1-9][0-9]*)|([0-9]*[1-9][0-9]*\.[0-9]+)|([0-9]*[1-9][0-9]*))$/ ;
	return re.test(s);
}
//实际上这里是非负整数
function isPositiveInt(s){
	var re=/^\d+$/;
	return re.test(s);
	
}
function isTimeSecond(s){
var reDateTime =/^(?:19|20)[0-9][0-9]-(?:(?:0[1-9])|(?:1[0-2]))-(?:(?:[0-2][1-9])|(?:[1-3][0-1])) (?:(?:[0-2][0-3])|(?:[0-1][0-9])):[0-5][0-9]:[0-5][0-9]$/;
return reDateTime.test(s);
}
function isFloat(s){
	var re=/^(-?\d+)(\.\d+)?$/;
	return re.test(s);	
	
	
}