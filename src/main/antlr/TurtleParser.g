parser grammar TurtleParser;

options {
  language = Java;
  tokenVocab = TurtleLexer;
}

@header {
  package TP1;
}

document returns [ASD.Document out]
  : s=statements EOF { $out = new ASD.Document($s.out); }
  ;

statements returns [List<ASD.Declaration> out]
  : { $out = new ArrayList<ASD.Declaration>(); } (s=statement { $out.add($s.out); }) * 
  ;

statement returns [ASD.Declaration out]
  : b=bracket p=properties PERIOD { $out = new ASD.Declaration(new ASD.Sujet($b.out), $p.out); } 
  ;

properties returns [List<ASD.Propriete> out]
  : { $out = new ArrayList<ASD.Propriete>(); } p=property { $out.add($p.out); } (SEMIC p=property { $out.add($p.out); })*
  ;

property returns [ASD.Propriete out]
  : b=bracket o=objects { $out = new ASD.Propriete(new ASD.Predicat($b.out), $o.out); }
  ;

objects returns [List<ASD.Objet> out]
  : { $out = new ArrayList<ASD.Objet>(); } o1=object { $out.add($o1.out); } (COMA o2=object { $out.add($o2.out); })*
  ;

object returns [ASD.Objet out]
  : b=bracket { $out = $b.out; } 
  | s=STRING { $out = new ASD.Text($s.text.substring(1, $s.text.length()-1)); }
  ;

bracket returns [ASD.Entity out]
  : s=ENTITY { $out = new ASD.Entity($s.text.substring(1, $s.text.length()-1)); }
  ;