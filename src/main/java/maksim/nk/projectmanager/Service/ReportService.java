package maksim.nk.projectmanager.Service;

import maksim.nk.projectmanager.Model.Report;
import maksim.nk.projectmanager.Repositories.ReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ReportService {

    private final ReportRepository reportRepository;

    @Autowired
    public ReportService(ReportRepository reportRepository) {
        this.reportRepository = reportRepository;
    }

    public void saveReport(Report report) {
        reportRepository.save(report);
    }

    public List<Report> getAllReports() {
        return reportRepository.findAll();
    }

    public Report getReportById(Long reportId) {
        return reportRepository.findById(reportId).orElse(null);
    }

    public void updateReport(Report report) {
        reportRepository.save(report);
    }

    public void deleteReport(Long reportId) {
        reportRepository.deleteById(reportId);
    }
}
