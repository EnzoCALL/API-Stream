package org.example;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;//
class MainStreamPersonne {
    public static void main(String[] arg) {
/**
 * Création de la liste de Personnes
 **/
        List<Personne> listP = Arrays.asList(
                new Personne(1.80, 70, "A", "Nicolas", Couleur.BLEU),
                new Personne(1.56, 50, "B", "Nicole", Couleur.VERRON),
                new Personne(1.75, 65, "C", "Germain", Couleur.VERT),
                new Personne(1.68, 50, "D", "Michel", Couleur.ROUGE),
                new Personne(1.96, 65, "E", "Cyrille", Couleur.BLEU),
                new Personne(2.10, 120, "F", "Denis", Couleur.ROUGE),
                new Personne(1.90, 90, "G", "Olivier", Couleur.VERRON)
        );
        Stream<Personne> sp = listP.stream();
        sp.forEach(System.out::println);
        System.out.println("\nAprés le filtre");
/**
 * Afficher les personnes dont le poids est
 * > 50 par la méthode filter
 **/
        sp = listP.stream();
        sp.filter(x -> x.getPoids() > 50).forEach(System.out::println);
        System.out.println("\nAprès le filtre et le map");
/**
 * Afficher uniquement les poids de chaque personne
 * -> 50 par la méthode filter
 **/
        sp = listP.stream();
        sp. filter(x -> x.getPoids() > 50).map(x -> x.getPoids())
                .forEach(System.out::println);

        System.out.println("\nAprès le filtre et le map et reduce");
/**
 * Utilisation de la mèthode reduce pour obtenir
 * une somme
 **/
        sp = listP.stream();
        Double sum = sp .filter(x -> x.getPoids() > 50).map(x -> x.getPoids())
                .reduce(0.0d, (x,y) -> x+y);
        System.out.println(sum);/** Affichage de la somme **/
        System.out.println("\nAprès le filtre et le map et reduce <Optional>");
/**
 * Utilisation du type Optional pour avoir
 * un complément pour aller plus loin avec
 * la méthode reduce(...)
 **/
        sp = listP.stream();
        Optional<Double> sumoptional =
                sp.filter(x -> x.getPoids() > 250).map(x -> x.getPoids()).reduce((x,y) -> x+y);
        if(sumoptional.isPresent()) System.out.println(sumoptional.get());
        else
            System.out.println("Aucun aggrègat de poids...");
/**
 * Permet de gèrer le cas d'erreur en
 * renvoyant 0.0 si isPresent() == false
 **/
        System.out.println("Ispresent() : "+sumoptional.orElse(0.0));
/**
 * La mèthode count() du stream après un filter...
 **/
        sp = listP.stream();
        long count = sp.filter(x -> x.getPoids() > 50).map(x -> x.getPoids()).count();
        System.out.println("Nombre d'éléments : " + count);/** Affichage d’un compteur **/
/**
 * Utilisation de l'interface Collectors...
 * On obtient le tableau automatique des poids
 * de chaque personne.
 **/
        sp = listP.stream();
        List<Double> ld = sp.filter(x -> x.getPoids() > 50).map(x ->
                x.getPoids()).collect(Collectors.toList());
        System.out.println(ld);/** Affiche le poids **/
    }
}