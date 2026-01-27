package controller;

import repository.ProfessorRepository;
import view.JanelaProfessor;

public class ProfessorController {

    private ProfessorRepository professorRepository;
    private JanelaProfessor janelaProfessor;

    public ProfessorController(ProfessorRepository professorRepository, JanelaProfessor janelaProfessor) {
        this.professorRepository = professorRepository;
        this.janelaProfessor = janelaProfessor;
    }

}
