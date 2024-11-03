package com.example.cleancodepluginandjava.core.tasks;

import java.util.List;

import com.example.cleancodepluginandjava.core.Dico.Dico;
import com.example.cleancodepluginandjava.core.utils.EditFileUtils;
import com.example.cleancodepluginandjava.core.utils.Utils;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExportPageCleanTask {

    public static void exportPageCleanTask(List<String> contents, String path) {
        // Création du motif regex pour LocalizedFragment
        String matchLocalizedFragment = Dico.Regex.MATCH_LOCALIZED_FRAGMENT_PART1 + Utils.getTri() + Dico.Regex.MATCH_LOCALIZED_FRAGMENT_PART2;

        int indexStart = Utils.getLineIndex(contents, matchLocalizedFragment);
        int indexEnd = Utils.getLineIndexFromStart(contents, Dico.Regex.MATCH_ARROW, indexStart) - 1;

        // Création de la liste des propriétés importées
        List<String> listImportedProps = new ArrayList<>();
        for (String content : contents.subList(indexStart, indexEnd)) {
            String cleanedContent = content.replace(" ", "").replace("\n", "").replace("\t", "").replace(",", "");
            listImportedProps.add(cleanedContent);
        }
        System.out.println("list_imported_props\n" + listImportedProps);

        String pathOfPage = Utils.getPageFromView(path);
        List<String> contentsExport = EditFileUtils.readFile(pathOfPage);
        int indexStartToCheck = Utils.getLineIndex(
                contentsExport,
                "<" + Utils.getFileName(path).substring(0, Utils.getFileName(path).lastIndexOf(".jsx")));
        int indexEndToCheck = Utils.getLineIndexFromStart(contentsExport, Dico.Regex.MATCH_AUTO_CLOSE, indexStartToCheck) - 1;

        List<String> listPropsToCheck = contentsExport.subList(indexStartToCheck, indexEndToCheck);
        System.out.println("list_props_to_check\n" + listPropsToCheck);

        // Création de la liste des propriétés à conserver
        List<Integer> listPropsToDelete = new ArrayList<>();
        for (int i = 0; i < listPropsToCheck.size(); i++) {
            String props = listPropsToCheck.get(i);
            boolean toAdd = true;
            for (String line : listImportedProps) {
                Pattern pattern = Pattern.compile(line + Dico.Regex.MATCH_WITH_NO_LETTER_AND_NUMBER);
                Matcher matcher = pattern.matcher(props);
                if (matcher.find()) {
                    toAdd = false;
                    break;
                }
            }
            if (toAdd) {
                listPropsToDelete.add(i);
            }
        }
        System.out.println("list_props_to_save\n" + listPropsToDelete);



        // Suppression des propriétés inutiles dans le contenu
        for (int i = listPropsToDelete.size() - 1; i >= 0; i--) {
            contentsExport.remove(indexStartToCheck + listPropsToDelete.get(i));
        }
        EditFileUtils.setContents(pathOfPage, contentsExport);
    }

}