package br.com.iron.util;

import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;
import org.hibernate.Session;

/**
 *
 * @author Rhuan
 */
public class PhaseListenerIron implements PhaseListener {

    //antes da fase
    @Override
    public void afterPhase(PhaseEvent fase) {
        System.out.println("Antes da fase:"+getPhaseId());
        if(fase.getPhaseId().equals(PhaseId.RESTORE_VIEW)){
            //abre sessao do hibernate
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            FacesContextUtil.setRequestSession(session);
        }
    }

    //depois da fase
    @Override
    public void beforePhase(PhaseEvent fase) {
        System.out.println("Depois da fase:"+getPhaseId());
        if(fase.getPhaseId().equals(PhaseId.RENDER_RESPONSE)){
          //obtendo a sessao de volta
            Session  session = FacesContextUtil.getRequestSession();
            try{
                session.getTransaction().commit();
            }catch(Exception e){
             if(session.getTransaction().isActive()){
                 session.getTransaction().rollback();
             }
            }finally{
                session.close();
            }
        }
        
    }

    
    @Override
    public PhaseId getPhaseId() {
       return PhaseId.ANY_PHASE;
    }
    
}
