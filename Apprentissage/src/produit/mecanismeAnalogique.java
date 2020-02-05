package produit;

	public class mecanismeAnalogique extends Mecanisme {
		private int date;
		public mecanismeAnalogique(double valeurDeBase, String uneHeure, int uneDate) {
			super(valeurDeBase,uneHeure);
			date = uneDate;
		}
		
		@Override
		protected String toStringType () {
			return "analogique";
		}	
}
