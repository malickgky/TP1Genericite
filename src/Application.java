
import java.util.List;
import java.util.Scanner;

    public class Application {
        public static void main(String[] args) {
            MetierProduitImpl metier = new MetierProduitImpl();
            Scanner scanner = new Scanner(System.in);
            int choix;

            do {
                System.out.println("Menu :");
                System.out.println("1. Afficher la liste des produits");
                System.out.println("2. Rechercher un produit par son id");
                System.out.println("3. Ajouter un nouveau produit dans la liste");
                System.out.println("4. Supprimer un produit par id");
                System.out.println("5. Quitter");
                System.out.print("Votre choix : ");
                choix = scanner.nextInt();

                switch (choix) {
                    case 1:
                        List<Produit> produits = metier.getAll();
                        if (produits.isEmpty()) {
                            System.out.println("Aucun produit disponible.");
                        } else {
                            produits.forEach(System.out::println);
                        }
                        break;
                    case 2:
                        System.out.print("Entrez l'ID du produit à rechercher : ");
                        long idRecherche = scanner.nextLong();
                        Produit produitTrouve = metier.findById(idRecherche);
                        if (produitTrouve != null) {
                            System.out.println("Produit trouvé : " + produitTrouve);
                        } else {
                            System.out.println("Produit non trouvé.");
                        }
                        break;
                    case 3:
                        System.out.print("Entrez l'ID du produit : ");
                        long id = scanner.nextLong();
                        scanner.nextLine(); // Consommer la nouvelle ligne
                        System.out.print("Entrez le nom du produit : ");
                        String nom = scanner.nextLine();
                        System.out.print("Entrez la marque du produit : ");
                        String marque = scanner.nextLine();
                        System.out.print("Entrez le prix du produit : ");
                        double prix = scanner.nextDouble();
                        scanner.nextLine(); // Consommer la nouvelle ligne
                        System.out.print("Entrez la description du produit : ");
                        String description = scanner.nextLine();
                        System.out.print("Entrez le nombre en stock : ");
                        int stock = scanner.nextInt();

                        Produit nouveauProduit = new Produit(id, nom, marque, prix, description, stock);
                        metier.add(nouveauProduit);
                        System.out.println("Produit ajouté avec succès.");
                        break;
                    case 4:
                        System.out.print("Entrez l'ID du produit à supprimer : ");
                        long idASupprimer = scanner.nextLong();
                        metier.delete(idASupprimer);
                        System.out.println("Produit supprimé si existait.");
                        break;
                    case 5:
                        System.out.println("Au revoir !");
                        break;
                    default:
                        System.out.println("Choix invalide, veuillez réessayer.");
                }
            } while (choix != 5);

            scanner.close();
        }
    }

