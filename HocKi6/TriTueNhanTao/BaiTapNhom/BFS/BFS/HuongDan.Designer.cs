namespace BFS
{
	partial class HuongDan
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
            System.ComponentModel.ComponentResourceManager resources = new System.ComponentModel.ComponentResourceManager(typeof(HuongDan));
            this.button3 = new System.Windows.Forms.Button();
            this.groupBox1 = new System.Windows.Forms.GroupBox();
            this.InputBreathFS = new System.Windows.Forms.PictureBox();
            this.InputBestFS = new System.Windows.Forms.PictureBox();
            this.btnBestFS = new System.Windows.Forms.Button();
            this.btnBreathFS = new System.Windows.Forms.Button();
            this.groupBox2 = new System.Windows.Forms.GroupBox();
            this.groupBox1.SuspendLayout();
            ((System.ComponentModel.ISupportInitialize)(this.InputBreathFS)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.InputBestFS)).BeginInit();
            this.groupBox2.SuspendLayout();
            this.SuspendLayout();
            // 
            // button3
            // 
            this.button3.Location = new System.Drawing.Point(472, 681);
            this.button3.Name = "button3";
            this.button3.Size = new System.Drawing.Size(137, 49);
            this.button3.TabIndex = 6;
            this.button3.Text = "Thoát";
            this.button3.UseVisualStyleBackColor = true;
            this.button3.Click += new System.EventHandler(this.button3_Click);
            // 
            // groupBox1
            // 
            this.groupBox1.Controls.Add(this.InputBreathFS);
            this.groupBox1.Controls.Add(this.InputBestFS);
            this.groupBox1.Dock = System.Windows.Forms.DockStyle.Top;
            this.groupBox1.Location = new System.Drawing.Point(3, 18);
            this.groupBox1.Name = "groupBox1";
            this.groupBox1.Size = new System.Drawing.Size(1056, 586);
            this.groupBox1.TabIndex = 3;
            this.groupBox1.TabStop = false;
            this.groupBox1.Text = "Hướng dẫn nhập file input";
            this.groupBox1.Enter += new System.EventHandler(this.groupBox1_Enter);
            // 
            // InputBreathFS
            // 
            this.InputBreathFS.Dock = System.Windows.Forms.DockStyle.Fill;
            this.InputBreathFS.Image = ((System.Drawing.Image)(resources.GetObject("InputBreathFS.Image")));
            this.InputBreathFS.Location = new System.Drawing.Point(3, 18);
            this.InputBreathFS.Name = "InputBreathFS";
            this.InputBreathFS.Size = new System.Drawing.Size(1050, 565);
            this.InputBreathFS.SizeMode = System.Windows.Forms.PictureBoxSizeMode.StretchImage;
            this.InputBreathFS.TabIndex = 1;
            this.InputBreathFS.TabStop = false;
            // 
            // InputBestFS
            // 
            this.InputBestFS.Dock = System.Windows.Forms.DockStyle.Fill;
            this.InputBestFS.Image = ((System.Drawing.Image)(resources.GetObject("InputBestFS.Image")));
            this.InputBestFS.Location = new System.Drawing.Point(3, 18);
            this.InputBestFS.Name = "InputBestFS";
            this.InputBestFS.Size = new System.Drawing.Size(1050, 565);
            this.InputBestFS.SizeMode = System.Windows.Forms.PictureBoxSizeMode.StretchImage;
            this.InputBestFS.TabIndex = 0;
            this.InputBestFS.TabStop = false;
            // 
            // btnBestFS
            // 
            this.btnBestFS.Location = new System.Drawing.Point(168, 610);
            this.btnBestFS.Name = "btnBestFS";
            this.btnBestFS.Size = new System.Drawing.Size(137, 49);
            this.btnBestFS.TabIndex = 4;
            this.btnBestFS.Text = "Best First Search";
            this.btnBestFS.UseVisualStyleBackColor = true;
            this.btnBestFS.Click += new System.EventHandler(this.btnBestFS_Click);
            // 
            // btnBreathFS
            // 
            this.btnBreathFS.Location = new System.Drawing.Point(735, 607);
            this.btnBreathFS.Name = "btnBreathFS";
            this.btnBreathFS.Size = new System.Drawing.Size(137, 52);
            this.btnBreathFS.TabIndex = 5;
            this.btnBreathFS.Text = "Breath First Search";
            this.btnBreathFS.UseVisualStyleBackColor = true;
            this.btnBreathFS.Click += new System.EventHandler(this.btnBreathFS_Click);
            // 
            // groupBox2
            // 
            this.groupBox2.Controls.Add(this.btnBreathFS);
            this.groupBox2.Controls.Add(this.btnBestFS);
            this.groupBox2.Controls.Add(this.groupBox1);
            this.groupBox2.Dock = System.Windows.Forms.DockStyle.Top;
            this.groupBox2.Location = new System.Drawing.Point(0, 0);
            this.groupBox2.Name = "groupBox2";
            this.groupBox2.Size = new System.Drawing.Size(1062, 675);
            this.groupBox2.TabIndex = 3;
            this.groupBox2.TabStop = false;
            // 
            // HuongDan
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(8F, 16F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(1062, 755);
            this.Controls.Add(this.button3);
            this.Controls.Add(this.groupBox2);
            this.Name = "HuongDan";
            this.Text = "HuongDan";
            this.Load += new System.EventHandler(this.HuongDan_Load);
            this.groupBox1.ResumeLayout(false);
            ((System.ComponentModel.ISupportInitialize)(this.InputBreathFS)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.InputBestFS)).EndInit();
            this.groupBox2.ResumeLayout(false);
            this.ResumeLayout(false);

		}

		#endregion
		private System.Windows.Forms.Button button3;
		private System.Windows.Forms.GroupBox groupBox1;
		private System.Windows.Forms.Button btnBestFS;
		private System.Windows.Forms.Button btnBreathFS;
		private System.Windows.Forms.GroupBox groupBox2;
		private System.Windows.Forms.PictureBox InputBestFS;
		private System.Windows.Forms.PictureBox InputBreathFS;
	}
}