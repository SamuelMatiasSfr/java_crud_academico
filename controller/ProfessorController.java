package controller;

import repository.ProfessorRepository;
import view.JanelaProfessor;

public class ProfessorController {

    private ProfessorRepository professorRepository;
    private JanelaProfessor janelaProfessor;

    public ProfessorController() {
        this.professorRepository = new ProfessorRepository();
        this.janelaProfessor = new JanelaProfessor();
    }

}
