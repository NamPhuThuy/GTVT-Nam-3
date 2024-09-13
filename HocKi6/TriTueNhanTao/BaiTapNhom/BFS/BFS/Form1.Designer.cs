namespace BFS
{
    partial class Form1
    {
        /// <summary>
        /// Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form Designer generated code

        /// <summary>
        /// Required method for Designer support - do not modify
        /// the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            this.components = new System.ComponentModel.Container();
            this.groupBox1 = new System.Windows.Forms.GroupBox();
            this.grbImg = new System.Windows.Forms.GroupBox();
            this.ptbCoTrongSO = new System.Windows.Forms.PictureBox();
            this.ptBKhongTrongSo = new System.Windows.Forms.PictureBox();
            this.groupBox3 = new System.Windows.Forms.GroupBox();
            this.txtTrongSo = new System.Windows.Forms.TextBox();
            this.lbTrongso = new System.Windows.Forms.Label();
            this.groupBox5 = new System.Windows.Forms.GroupBox();
            this.lstDanhSach = new System.Windows.Forms.ListView();
            this.columnHeader1 = ((System.Windows.Forms.ColumnHeader)(new System.Windows.Forms.ColumnHeader()));
            this.columnHeader2 = ((System.Windows.Forms.ColumnHeader)(new System.Windows.Forms.ColumnHeader()));
            this.txtDinhKe = new System.Windows.Forms.TextBox();
            this.label4 = new System.Windows.Forms.Label();
            this.txtDinh = new System.Windows.Forms.TextBox();
            this.label3 = new System.Windows.Forms.Label();
            this.btnADD = new System.Windows.Forms.Button();
            this.label2 = new System.Windows.Forms.Label();
            this.txtSoDinh = new System.Windows.Forms.TextBox();
            this.label1 = new System.Windows.Forms.Label();
            this.backgroundWorker1 = new System.ComponentModel.BackgroundWorker();
            this.grbChucNang = new System.Windows.Forms.GroupBox();
            this.btnHuongDan = new System.Windows.Forms.Button();
            this.btnTim = new System.Windows.Forms.Button();
            this.btnVe = new System.Windows.Forms.Button();
            this.btnImport = new System.Windows.Forms.Button();
            this.btnBFDko = new System.Windows.Forms.Button();
            this.btnBFDco = new System.Windows.Forms.Button();
            this.grbLoai = new System.Windows.Forms.GroupBox();
            this.textBox1 = new System.Windows.Forms.TextBox();
            this.contextMenuStrip1 = new System.Windows.Forms.ContextMenuStrip(this.components);
            this.lblThongBao = new System.Windows.Forms.Label();
            this.groupBox1.SuspendLayout();
            this.grbImg.SuspendLayout();
            ((System.ComponentModel.ISupportInitialize)(this.ptbCoTrongSO)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.ptBKhongTrongSo)).BeginInit();
            this.groupBox3.SuspendLayout();
            this.groupBox5.SuspendLayout();
            this.grbChucNang.SuspendLayout();
            this.grbLoai.SuspendLayout();
            this.SuspendLayout();
            // 
            // groupBox1
            // 
            this.groupBox1.Controls.Add(this.grbImg);
            this.groupBox1.Controls.Add(this.groupBox3);
            this.groupBox1.Controls.Add(this.txtSoDinh);
            this.groupBox1.Controls.Add(this.label1);
            this.groupBox1.Location = new System.Drawing.Point(12, 30);
            this.groupBox1.Name = "groupBox1";
            this.groupBox1.Size = new System.Drawing.Size(953, 686);
            this.groupBox1.TabIndex = 0;
            this.groupBox1.TabStop = false;
            this.groupBox1.Enter += new System.EventHandler(this.groupBox1_Enter);
            // 
            // grbImg
            // 
            this.grbImg.Controls.Add(this.ptbCoTrongSO);
            this.grbImg.Controls.Add(this.ptBKhongTrongSo);
            this.grbImg.Location = new System.Drawing.Point(323, 10);
            this.grbImg.Name = "grbImg";
            this.grbImg.Size = new System.Drawing.Size(619, 636);
            this.grbImg.TabIndex = 6;
            this.grbImg.TabStop = false;
            this.grbImg.Text = "Hướng dẫn (Hình ảnh minh họa)";
            // 
            // ptbCoTrongSO
            // 
            this.ptbCoTrongSO.Dock = System.Windows.Forms.DockStyle.Fill;
            this.ptbCoTrongSO.Image = global::BFS.Properties.Resources.bfdcots;
            this.ptbCoTrongSO.Location = new System.Drawing.Point(3, 18);
            this.ptbCoTrongSO.Name = "ptbCoTrongSO";
            this.ptbCoTrongSO.Size = new System.Drawing.Size(613, 615);
            this.ptbCoTrongSO.SizeMode = System.Windows.Forms.PictureBoxSizeMode.StretchImage;
            this.ptbCoTrongSO.TabIndex = 1;
            this.ptbCoTrongSO.TabStop = false;
            this.ptbCoTrongSO.Click += new System.EventHandler(this.ptbCoTrongSO_Click);
            // 
            // ptBKhongTrongSo
            // 
            this.ptBKhongTrongSo.Dock = System.Windows.Forms.DockStyle.Fill;
            this.ptBKhongTrongSo.Image = global::BFS.Properties.Resources.bfdkotrongso;
            this.ptBKhongTrongSo.Location = new System.Drawing.Point(3, 18);
            this.ptBKhongTrongSo.Name = "ptBKhongTrongSo";
            this.ptBKhongTrongSo.Size = new System.Drawing.Size(613, 615);
            this.ptBKhongTrongSo.SizeMode = System.Windows.Forms.PictureBoxSizeMode.StretchImage;
            this.ptBKhongTrongSo.TabIndex = 0;
            this.ptBKhongTrongSo.TabStop = false;
            // 
            // groupBox3
            // 
            this.groupBox3.Controls.Add(this.txtTrongSo);
            this.groupBox3.Controls.Add(this.lbTrongso);
            this.groupBox3.Controls.Add(this.groupBox5);
            this.groupBox3.Controls.Add(this.txtDinhKe);
            this.groupBox3.Controls.Add(this.label4);
            this.groupBox3.Controls.Add(this.txtDinh);
            this.groupBox3.Controls.Add(this.label3);
            this.groupBox3.Controls.Add(this.btnADD);
            this.groupBox3.Controls.Add(this.label2);
            this.groupBox3.Location = new System.Drawing.Point(9, 72);
            this.groupBox3.Name = "groupBox3";
            this.groupBox3.Size = new System.Drawing.Size(291, 463);
            this.groupBox3.TabIndex = 5;
            this.groupBox3.TabStop = false;
            this.groupBox3.Text = "Nhập các đỉnh và đỉnh kề của đỉnh đó:";
            // 
            // txtTrongSo
            // 
            this.txtTrongSo.Location = new System.Drawing.Point(92, 101);
            this.txtTrongSo.Name = "txtTrongSo";
            this.txtTrongSo.Size = new System.Drawing.Size(132, 22);
            this.txtTrongSo.TabIndex = 8;
            // 
            // lbTrongso
            // 
            this.lbTrongso.AutoSize = true;
            this.lbTrongso.Location = new System.Drawing.Point(6, 107);
            this.lbTrongso.Name = "lbTrongso";
            this.lbTrongso.Size = new System.Drawing.Size(64, 16);
            this.lbTrongso.TabIndex = 7;
            this.lbTrongso.Text = "Trọng số:";
            // 
            // groupBox5
            // 
            this.groupBox5.Controls.Add(this.lstDanhSach);
            this.groupBox5.Location = new System.Drawing.Point(9, 182);
            this.groupBox5.Name = "groupBox5";
            this.groupBox5.Size = new System.Drawing.Size(279, 257);
            this.groupBox5.TabIndex = 0;
            this.groupBox5.TabStop = false;
            this.groupBox5.Text = "Danh sách đỉnh";
            // 
            // lstDanhSach
            // 
            this.lstDanhSach.Columns.AddRange(new System.Windows.Forms.ColumnHeader[] {
            this.columnHeader1,
            this.columnHeader2});
            this.lstDanhSach.Dock = System.Windows.Forms.DockStyle.Fill;
            this.lstDanhSach.GridLines = true;
            this.lstDanhSach.HideSelection = false;
            this.lstDanhSach.Location = new System.Drawing.Point(3, 18);
            this.lstDanhSach.Name = "lstDanhSach";
            this.lstDanhSach.Size = new System.Drawing.Size(273, 236);
            this.lstDanhSach.TabIndex = 0;
            this.lstDanhSach.UseCompatibleStateImageBehavior = false;
            this.lstDanhSach.View = System.Windows.Forms.View.Details;
            // 
            // columnHeader1
            // 
            this.columnHeader1.Text = "Đỉnh";
            this.columnHeader1.Width = 70;
            // 
            // columnHeader2
            // 
            this.columnHeader2.Text = "Danh sách đỉnh kề";
            this.columnHeader2.Width = 185;
            // 
            // txtDinhKe
            // 
            this.txtDinhKe.Location = new System.Drawing.Point(92, 63);
            this.txtDinhKe.Name = "txtDinhKe";
            this.txtDinhKe.Size = new System.Drawing.Size(132, 22);
            this.txtDinhKe.TabIndex = 8;
            // 
            // label4
            // 
            this.label4.AutoSize = true;
            this.label4.Location = new System.Drawing.Point(6, 69);
            this.label4.Name = "label4";
            this.label4.Size = new System.Drawing.Size(54, 16);
            this.label4.TabIndex = 7;
            this.label4.Text = "Đỉnh kề:";
            // 
            // txtDinh
            // 
            this.txtDinh.Location = new System.Drawing.Point(92, 26);
            this.txtDinh.Name = "txtDinh";
            this.txtDinh.Size = new System.Drawing.Size(132, 22);
            this.txtDinh.TabIndex = 6;
            // 
            // label3
            // 
            this.label3.AutoSize = true;
            this.label3.Location = new System.Drawing.Point(6, 32);
            this.label3.Name = "label3";
            this.label3.Size = new System.Drawing.Size(36, 16);
            this.label3.TabIndex = 5;
            this.label3.Text = "Đỉnh:";
            // 
            // btnADD
            // 
            this.btnADD.Location = new System.Drawing.Point(210, 153);
            this.btnADD.Name = "btnADD";
            this.btnADD.Size = new System.Drawing.Size(75, 23);
            this.btnADD.TabIndex = 4;
            this.btnADD.Text = "Thêm";
            this.btnADD.UseVisualStyleBackColor = true;
            // 
            // label2
            // 
            this.label2.AutoSize = true;
            this.label2.Location = new System.Drawing.Point(21, 38);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(0, 16);
            this.label2.TabIndex = 2;
            // 
            // txtSoDinh
            // 
            this.txtSoDinh.Location = new System.Drawing.Point(92, 30);
            this.txtSoDinh.Name = "txtSoDinh";
            this.txtSoDinh.Size = new System.Drawing.Size(105, 22);
            this.txtSoDinh.TabIndex = 1;
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Location = new System.Drawing.Point(6, 36);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(55, 16);
            this.label1.TabIndex = 0;
            this.label1.Text = "Số đỉnh:";
            // 
            // grbChucNang
            // 
            this.grbChucNang.Controls.Add(this.btnHuongDan);
            this.grbChucNang.Controls.Add(this.btnTim);
            this.grbChucNang.Controls.Add(this.btnVe);
            this.grbChucNang.Controls.Add(this.btnImport);
            this.grbChucNang.Location = new System.Drawing.Point(977, 437);
            this.grbChucNang.Name = "grbChucNang";
            this.grbChucNang.Size = new System.Drawing.Size(143, 159);
            this.grbChucNang.TabIndex = 1;
            this.grbChucNang.TabStop = false;
            this.grbChucNang.Text = "Chức năng";
            // 
            // btnHuongDan
            // 
            this.btnHuongDan.Location = new System.Drawing.Point(6, 115);
            this.btnHuongDan.Name = "btnHuongDan";
            this.btnHuongDan.Size = new System.Drawing.Size(124, 27);
            this.btnHuongDan.TabIndex = 3;
            this.btnHuongDan.Text = "Hướng dẫn";
            this.btnHuongDan.UseVisualStyleBackColor = true;
            this.btnHuongDan.Click += new System.EventHandler(this.btnHuongDan_Click);
            // 
            // btnTim
            // 
            this.btnTim.Location = new System.Drawing.Point(6, 21);
            this.btnTim.Name = "btnTim";
            this.btnTim.Size = new System.Drawing.Size(124, 25);
            this.btnTim.TabIndex = 0;
            this.btnTim.Text = "Tìm đường đi";
            this.btnTim.UseVisualStyleBackColor = true;
            this.btnTim.Click += new System.EventHandler(this.btnTim_Click);
            // 
            // btnVe
            // 
            this.btnVe.Location = new System.Drawing.Point(6, 52);
            this.btnVe.Name = "btnVe";
            this.btnVe.Size = new System.Drawing.Size(124, 24);
            this.btnVe.TabIndex = 1;
            this.btnVe.Text = "Vẽ đồ thị";
            this.btnVe.UseVisualStyleBackColor = true;
            this.btnVe.Click += new System.EventHandler(this.btnVe_Click);
            // 
            // btnImport
            // 
            this.btnImport.Location = new System.Drawing.Point(6, 82);
            this.btnImport.Name = "btnImport";
            this.btnImport.Size = new System.Drawing.Size(124, 27);
            this.btnImport.TabIndex = 2;
            this.btnImport.Text = "Import File";
            this.btnImport.UseVisualStyleBackColor = true;
            this.btnImport.Click += new System.EventHandler(this.btnImport_Click);
            // 
            // btnBFDko
            // 
            this.btnBFDko.Location = new System.Drawing.Point(6, 23);
            this.btnBFDko.Name = "btnBFDko";
            this.btnBFDko.Size = new System.Drawing.Size(137, 25);
            this.btnBFDko.TabIndex = 4;
            this.btnBFDko.Text = "Breath First Search";
            this.btnBFDko.UseVisualStyleBackColor = true;
            this.btnBFDko.Click += new System.EventHandler(this.btnBFDko_Click);
            // 
            // btnBFDco
            // 
            this.btnBFDco.Location = new System.Drawing.Point(6, 54);
            this.btnBFDco.Name = "btnBFDco";
            this.btnBFDco.Size = new System.Drawing.Size(137, 26);
            this.btnBFDco.TabIndex = 5;
            this.btnBFDco.Text = "Best First Search";
            this.btnBFDco.UseVisualStyleBackColor = true;
            this.btnBFDco.Click += new System.EventHandler(this.btnBFDco_Click);
            // 
            // grbLoai
            // 
            this.grbLoai.Controls.Add(this.btnBFDko);
            this.grbLoai.Controls.Add(this.btnBFDco);
            this.grbLoai.Location = new System.Drawing.Point(971, 25);
            this.grbLoai.Name = "grbLoai";
            this.grbLoai.Size = new System.Drawing.Size(190, 116);
            this.grbLoai.TabIndex = 6;
            this.grbLoai.TabStop = false;
            this.grbLoai.Text = "Thuật toán";
            this.grbLoai.Enter += new System.EventHandler(this.grbLoai_Enter);
            // 
            // textBox1
            // 
            this.textBox1.Location = new System.Drawing.Point(977, 171);
            this.textBox1.Multiline = true;
            this.textBox1.Name = "textBox1";
            this.textBox1.ScrollBars = System.Windows.Forms.ScrollBars.Vertical;
            this.textBox1.Size = new System.Drawing.Size(212, 260);
            this.textBox1.TabIndex = 8;
            this.textBox1.TextChanged += new System.EventHandler(this.textBox1_TextChanged);
            // 
            // contextMenuStrip1
            // 
            this.contextMenuStrip1.ImageScalingSize = new System.Drawing.Size(20, 20);
            this.contextMenuStrip1.Name = "contextMenuStrip1";
            this.contextMenuStrip1.Size = new System.Drawing.Size(61, 4);
            // 
            // lblThongBao
            // 
            this.lblThongBao.AutoSize = true;
            this.lblThongBao.Font = new System.Drawing.Font("Times New Roman", 11.5F);
            this.lblThongBao.Location = new System.Drawing.Point(400, 9);
            this.lblThongBao.Name = "lblThongBao";
            this.lblThongBao.Size = new System.Drawing.Size(387, 22);
            this.lblThongBao.TabIndex = 7;
            this.lblThongBao.Text = "Vui lòng chọn một trong ba thuật toán để bắt dầu";
            // 
            // Form1
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(8F, 16F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(1243, 728);
            this.Controls.Add(this.textBox1);
            this.Controls.Add(this.lblThongBao);
            this.Controls.Add(this.grbLoai);
            this.Controls.Add(this.grbChucNang);
            this.Controls.Add(this.groupBox1);
            this.Name = "Form1";
            this.Text = "Form1";
            this.Load += new System.EventHandler(this.Form1_Load);
            this.groupBox1.ResumeLayout(false);
            this.groupBox1.PerformLayout();
            this.grbImg.ResumeLayout(false);
            ((System.ComponentModel.ISupportInitialize)(this.ptbCoTrongSO)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.ptBKhongTrongSo)).EndInit();
            this.groupBox3.ResumeLayout(false);
            this.groupBox3.PerformLayout();
            this.groupBox5.ResumeLayout(false);
            this.grbChucNang.ResumeLayout(false);
            this.grbLoai.ResumeLayout(false);
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.GroupBox groupBox1;
        private System.Windows.Forms.Label label2;
        private System.Windows.Forms.TextBox txtSoDinh;
        private System.Windows.Forms.Label label1;
        private System.ComponentModel.BackgroundWorker backgroundWorker1;
        private System.Windows.Forms.GroupBox grbChucNang;
        private System.Windows.Forms.Button btnImport;
        private System.Windows.Forms.Button btnVe;
        private System.Windows.Forms.Button btnTim;
        private System.Windows.Forms.GroupBox grbImg;
        private System.Windows.Forms.GroupBox groupBox3;
        private System.Windows.Forms.TextBox txtDinhKe;
        private System.Windows.Forms.Label label4;
        private System.Windows.Forms.TextBox txtDinh;
        private System.Windows.Forms.Label label3;
        private System.Windows.Forms.Button btnADD;
        private System.Windows.Forms.GroupBox groupBox5;
        private System.Windows.Forms.ListView lstDanhSach;
        private System.Windows.Forms.ColumnHeader columnHeader1;
        private System.Windows.Forms.ColumnHeader columnHeader2;
        private System.Windows.Forms.Button btnBFDco;
        private System.Windows.Forms.Button btnBFDko;
        private System.Windows.Forms.TextBox txtTrongSo;
        private System.Windows.Forms.Label lbTrongso;
        private System.Windows.Forms.GroupBox grbLoai;
        private System.Windows.Forms.PictureBox ptBKhongTrongSo;
        private System.Windows.Forms.PictureBox ptbCoTrongSO;
        private System.Windows.Forms.TextBox textBox1;
        private System.Windows.Forms.ContextMenuStrip contextMenuStrip1;
		private System.Windows.Forms.Button btnHuongDan;
        private System.Windows.Forms.Label lblThongBao;
    }
}

