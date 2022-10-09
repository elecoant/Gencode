package TP1;

import java.util.List;

public class ASD {
	public static class Document {
		private List<Declaration> declarations;
		
		public Document(List<Declaration> declarations) {
			this.declarations = declarations;
		}
		
		public List<Declaration> getDeclaration() { return declarations; }
		
		public void setDeclaration(List<Declaration> declarations) { this.declarations = declarations; }

		public String toNtriples() {
			String res = "";
			for(Declaration decl : declarations) {
				res = res.concat(decl.toNtriples());
			}
			return res;
		}
	}

	public static class Declaration {
		private Sujet sujet;
		private List<Propriete> proprietes;
		
		public Declaration(Sujet sujet, List<Propriete> proprietes) {
			this.sujet =sujet;
			this.proprietes = proprietes;
		}
		
		private String toNtriples() {
			String res = "";
				
			for(Propriete prop : proprietes) {
				res = res.concat(prop.toNtriples(sujet));
			}

			return res;
		}
		
		public Sujet getSujet() { return sujet; }
			
		public void setSujet(Sujet sujet) { this.sujet = sujet; }
			
		public List<Propriete> getPropriete() { return proprietes; }
			
		public void setPropriete(List<Propriete> proprietes) { this.proprietes = proprietes; }
	}

	public static class Sujet {
		private Entity entity;
		
		public Sujet(Entity entity) {
			this.entity = entity;
		}
		
		private String toNtriples() {
			return entity.toNtriples();
		}

		public Entity getEntity() { return entity; }

		public void setEntity(Entity entity) { this.entity = entity; }
	}
	
	public static class Propriete {
			private Predicat predicat;
			private List<Objet> objets;
		
		public Propriete(Predicat predicat, List<Objet> objets) {
			this.predicat = predicat;
			this.objets = objets;
		}
		
		private String toNtriples(Sujet sujet) {
			String res = "";
			
			for(Objet objet : objets) {
				res = res.concat(sujet.toNtriples());
				res = res.concat(predicat.toNtriples());
				res = res.concat(objet.toNtriples());
				res = res.concat(".\n");
			}
			
			return res;
		}

		public Predicat getPredicat() { return predicat; }

		public void setPredicat(Predicat predicat) { this.predicat = predicat; }

		public List<Objet> getObjets() { return objets; }

		public void setObjets(List<Objet> objets) { this.objets = objets; }
		
	}

	public static abstract class Objet { 
		abstract protected String toNtriples();
	}

	public static class Text extends Objet {
		private String s;
		
		public Text(String s) {
			this.s = s;
		}
		
		protected String toNtriples() {
			return "\"" + s + "\" ";
		}

		public String getS() { return s; }

		public void setS(String s) { this.s = s; }
		
	}

	public static class Entity extends Objet {
		private String s;
		
		public Entity(String s) {
			this.s = s;
		}
		
		protected String toNtriples() {
			return "<" + s + "> ";
		}
		
		public String getS() { return s; }

		public void setS(String s) { this.s = s; }
	}

	public static class Predicat {
		private Entity entity;
		
		public Predicat(Entity entity) { 
			this.entity = entity; 
		}
		
		private String toNtriples() {
			return entity.toNtriples();
		}
		
		public Entity getEntity() { return entity; }

		public void setEntity(Entity entity) { this.entity = entity; }

	}

}
