specification Lukavronb;


syntax Lukavronb{
	sort valuation;
	sort formula;
	valuation true = 'T' formula;
	valuation false = 'F' formula;
	formula	negation = '!' formula;
	formula	conjunction = formula '&' formula;
	formula	disjunction = formula '|' formula;
	formula	implication = formula '->' formula;
}

tableau Lukavronb {
	T P  F P / priority 0$;
	T (P & Q) / T P  T Q priority 1$;       
	F (P & Q) /  F P $| F Q priority 2$;
	T (P | Q) / T P $| T Q priority 2$;
	F (P | Q) /  F P  F Q priority 1$;
	F (!(!(P))) / F P priority 1$;
	T (!(!(P))) / T P priority 1$;
	F !(P) / T P priority 1$;
	T (!(P | Q)) / T !P  T !Q priority 1$;
	F (!(P | Q)) / F !P $| F !Q priority 2$;
	T (!(P & Q)) / T !P $| T !Q priority 2$;
	F (!(P & Q)) / F !P  F !Q priority 1$;
	T (P->Q) / F P  F !Q $| F P  T !P $| T Q  F !Q $| T Q  T !P priority 4$;
	F (P->Q) / T P  F Q  F !P  $| T !Q  F Q  F !P priority 3$;
	T !(P->Q) / T P  T !Q priority 1$;
	F !(P->Q) / F P $| F !Q priority 2$;
}
