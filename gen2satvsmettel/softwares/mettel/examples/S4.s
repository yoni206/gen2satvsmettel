specification S4;
options{
name.separator=
tableau.rule.delimiter=;
tableau.rule.branch.delimiter=||
}
syntax S4{
	sort formula, world;
	formula false = 'false';
	formula	negation = '~' formula;
	formula diamond = '<>' formula;
	formula at = '@' world formula;
	formula	disjunction  = formula '|' formula;
	formula equality = '[' world '=' world ']'; //Equality
	formula relation = 'R' '(' world ',' world ')'; //Relation
	world f = 'f' '('  world ',' formula  ')'; //Skolem function
}
tableau S4{
	@i ~(~P) / @i P priority 1; //Double-negation removal
	@i(P|Q) / @i P || @i Q priority 3; //Disjunction rule
	@i~(P|Q) / @i~P @i~Q priority 1; //"Conjunction" rule
	@i<>P / R(i,f(i,P)) @f(i,P)P priority 7; //Diamond rule
	@i~(<>P) R(i,j) / @j~P priority 2; //"Box" propagation rule
	@i P / R(i,i) priority 1; //Reflexivity
	R(i,j) R(j,k) / R(i,k) priority 2; //Transitivity
	@i P  @i~P /  priority 0; //Closure rule
	R(i,j) / [i=j] || ~([i=j]) priority 6; //Ancestor blocking rule
	~([i=i])/ priority 0; //Closure rule for inequality
}
